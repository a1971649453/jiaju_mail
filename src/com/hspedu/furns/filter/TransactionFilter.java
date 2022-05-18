package com.hspedu.furns.filter; /**
 * @author 金宗文
 * @version 1.0
 */

import com.hspedu.furns.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            JDBCUtilsByDruid.commit();
        } catch (Exception e) {//如果出错 就回滚
            JDBCUtilsByDruid.rollback();
            e.printStackTrace();
        }

    }
}
