<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<s:form action="/registration" method="post" modelAttribute="newUser">
    <s:input path="name" placeholder="Input name"/>
    <br>
    <s:errors path="name" cssStyle="color: red"/>
    <br>
    <s:input path="email" placeholder="Input email"/>
    <br>
    <s:errors path="email" cssStyle="color: red"/>
    <br>
    <s:input path="password" type="password" placeholder="Input password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <s:button>Register</s:button>
    <a href="/startpage" class="btn btn-primary">Back</a>
</s:form>
<p style="color: red">${message}</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
