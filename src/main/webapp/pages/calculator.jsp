<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Operations setup</h3>
<s:form action="/calculator" method="post" modelAttribute="op">
    <s:input path="x1" placeholder="Input first number"/>
    <br>
    <s:errors path="x1" cssStyle="color: red"/>
    <br>
    <s:input path="x2" placeholder="Input second number"/>
    <br>
    <s:errors path="x2" cssStyle="color: red"/>
    <br>
    <s:radiobutton path="operation" value="sum"/> Addition<br/>
    <s:radiobutton path="operation" value="sub"/> Subtraction<br/>
    <s:radiobutton path="operation" value="mul"/> Multiplication<br/>
    <s:radiobutton path="operation" value="div"/> Division<br/>
    <s:button class="btn btn-primary"> Calculate</s:button>
    <a href="/startpage" class="btn btn-primary">Back</a>
</s:form>
<p style="color: red">${message}</p>
<p>${result}</p>
</body>
</html>