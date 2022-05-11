<%--
  Created by IntelliJ IDEA.
  User: 寂笙
  Date: 2022/5/5
  Time: 9:31
  Version: ${VERSION}
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--直接请求CustomerFurnServlet 获取网站首页要显示的分页数据--%>
<jsp:forward page="/CustomerFurnServlet?action=pageByName"></jsp:forward>