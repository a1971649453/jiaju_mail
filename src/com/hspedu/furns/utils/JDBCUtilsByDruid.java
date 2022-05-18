package com.hspedu.furns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 金宗文
 * @version 1.0
 * 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;
    //定义Threadlocal 存放一个Connection
    private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();

    //在静态代码块完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            //web项目 工作目录在web下 需要使用类加载器
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
//            properties.load(new FileInputStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    //编写getConnection方法
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }

    /**
     * 从ThredLocal获取Connection 从而保证为同一个线程中获取的用一个Connection
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocalConn.get();
        if (connection == null){//当前threadLocal没有连接
            try {
                connection = ds.getConnection();
                connection.setAutoCommit(false);//手动提交 开启事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocalConn.set(connection);//从数据库连接池里取一个放入
        }
        return connection;
    }

    //关闭连接, 老师再次强调： 在数据库连接池技术中，close 不是真的断掉连接
    //而是把使用的Connection对象放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //java基础 事务 线程 ThreadLocal
    public static  void  commit(){
        Connection connection = threadLocalConn.get();
        if (connection != null) {//确保该链接非空
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {//关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //提交后 需要将connection从ThreadLocal中 清除掉
        //2.不然会长时间持有该链接 会影响效率
        //3.也因为Tomcat底层使用线程池技术
        threadLocalConn.remove();
    }

    /**
     * 回滚 是回滚/撤销 和connection管理的操作 增删改查
     */
    public static void rollback(){
        Connection connection = threadLocalConn.get();
        if(connection != null){//保证当前链接有效
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        threadLocalConn.remove();
    }
}
