package com.hspedu.furns.test;

import com.hspedu.furns.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 金宗文
 * @version 1.0
 */
public class JDBCUtilsByDruidTest {
    @Test
    public void getConnection() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
