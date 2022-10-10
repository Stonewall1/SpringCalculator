<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<h3>Change your name and password</h3>
<s:form action="/user/editProfile" method="post" modelAttribute="newUser">
    <p>Change your name:</p>
    <s:input path="name" size="30" placeholder="New name"/>
    <br>
    <s:errors path="name" cssStyle="color: red;"/>
    <br>
    <p>Change your password:</p>
    <s:input path="password" size="30" placeholder="New password"/>
    <br>
    <s:errors path="password" cssStyle="color: red;"/>
    <br>
    <s:button>Edit</s:button>
</s:form>
</body>
</html>
