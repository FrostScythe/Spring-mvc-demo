<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Teacher</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>

<h1>Add New Teacher ➕</h1>

<form:form action="/teachers/add" method="post" modelAttribute="teacher">

    <label>Name:</label>
    <form:input path="name" placeholder="Enter Name"/>

    <label>Email:</label>
    <form:input path="email" placeholder="Enter Email"/>

    <label>Subject:</label>
    <form:select path="subject">
        <form:option value="">--Select Subject--</form:option>
        <form:option value="English">English</form:option>
        <form:option value="Spring">Spring</form:option>
        <form:option value="Hibernate">Hibernate</form:option>
        <form:option value="Electronic">Electronic</form:option>
        <form:option value="Communication">Communication</form:option>
    </form:select>

    <label>Department:</label>
    <form:select path="department">
        <form:option value="">--Select Department--</form:option>
        <form:option value="Information Technology">Information Technology</form:option>
        <form:option value="Electronic & Communication">Electronic & Communication</form:option>
        <form:option value="Literature">Literature</form:option>
        <form:option value="Mechanical">Mechanical</form:option>
    </form:select>

    <label>Experience:</label>
    <form:input path="experience" type="number" placeholder="Enter experience"/>

    <label>Salary:</label>
    <form:input path="salary" type="number" placeholder="Enter salary"/>

    <br/>

    <button type="submit" class="btn">Save Teacher</button>
    <a href="/teachers">Cancel</a>

</form:form>

</body>
</html>