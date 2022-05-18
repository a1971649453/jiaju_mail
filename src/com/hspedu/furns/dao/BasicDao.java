package com.hspedu.furns.dao;


import com.hspedu.furns.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 金宗文
 * @version 1.0
 */
public class BasicDao<T> {
    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法
    public int update(String sql, Object... params) {
        Connection conn = null;
        try {
            //从ThreadLocal 获取的connection
            // 所以保证的是同一个链接
            Connection connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //返回多个对象
    public List<T> queryMuti(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> queryMuti(String sql, Class<T> clazz)  {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz));
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //单行查询
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //单行单列
    public Object queryScalar(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
