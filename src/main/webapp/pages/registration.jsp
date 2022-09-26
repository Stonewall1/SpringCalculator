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
    <s:errors path="name"/>
    <br>
    <s:input path="email" placeholder="Input email"/>
    <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" placeholder="Input password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Register</s:button>
    <a href="/startpage" class="btn btn-primary">Back</a>
</s:form>
<p>${message}</p>

<%--<div class="container">--%>
<%--  <div class="row justify-content-center mt-5">--%>
<%--    <div class="col-6 text-center mt-5 ">--%>

<%--      <form action="/registration" method="post">--%>
<%--        <div class="mb-3">--%>
<%--          <label for="exampleInputEmail1" class="form-label">Name</label>--%>
<%--          <input type="name" name="name" class="form-control">--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--          <label for="exampleInputEmail1" class="form-label">Email address</label>--%>
<%--          <input type="email" name="email" class="form-control" id="exampleInputEmail1"--%>
<%--                 aria-describedby="emailHelp">--%>
<%--          <div id="emailHelp" class="form-text">We'll never share your email with anyone else</div>--%>
<%--        </div>--%>
<%--        <div class="mb-3">--%>
<%--          <label for="exampleInputPassword1" class="form-label">Password</label>--%>
<%--          <input type="password" name="password" class="form-control" id="exampleInputPassword1">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary">Register</button>--%>
<%--        <a href="/startpage" class="btn btn-primary">Back</a>--%>
<%--      </form>--%>
<%--      <p>${message}</p>--%>

<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
