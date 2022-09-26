<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Calculator</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<div class="container">
  <div class="row justify-content-center mt-5">
    <div class="col-8 text-left mt-5 ">

      <h3>Operations setup</h3>
      <ul>
        <li>sum - addition</li>
        <li>sub - subtraction</li>
        <li>mul - multiplication</li>
        <li>div - division</li>
      </ul>

      <form action="/calculator" method="post">
        <input type="number" name="x1" placeholder="Input first number">
        <input type="number" name="x2" placeholder="Input second number">
        <input type="text" name="operation" placeholder="Operation">
        <button class="btn btn-primary">Calculate</button>
        <a href="/startpage" class="btn btn-primary">Back</a>
      </form>

<%--      <s:form action="/calculator" method="post" modelAttribute="op">--%>
<%--        <s:input path="x1" placeholder="Input first number"/>--%>
<%--        <br>--%>
<%--        <s:errors path="x1"/>--%>
<%--        <br>--%>
<%--        <s:input path="x2" placeholder="Input second number"/>--%>
<%--        <br>--%>
<%--        <s:errors path="x2"/>--%>
<%--        <br>--%>
<%--        <s:input path="operation" placeholder="Input operation"/>--%>
<%--        <br>--%>
<%--        <s:errors path="operation"/>--%>
<%--        <br>--%>
<%--        <s:button  class="btn btn-primary"> Calculate</s:button>--%>
<%--        <a href="/startpage" class="btn btn-primary">Back</a>--%>
<%--      </s:form>--%>

      <p>${message}</p>
      <p>${result}</p>

    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>