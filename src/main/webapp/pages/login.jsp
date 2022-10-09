<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<s:form action="/login" method="post" modelAttribute="user">
    <s:input path="email" size="50" placeholder="Email"/>
    <br>
    <s:errors path="email" cssStyle="color: red"/>
    <br>
    <s:input path="password" size="50" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <s:button>Login</s:button>
</s:form>
<p style="color: red">${message}</p>
</body>
</html>