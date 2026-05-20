<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <h1>➕ Add New Student</h1>

    <form:form action="/students/add" method="post" modelAttribute="student" onsubmit="return validate()">

        <label>Name:</label>
        <form:input id="name" path="name" placeholder="Enter Name"/>

        <label>Email:</label>
        <form:input id="email" path="email" placeholder="Enter Email"/>

        <label>Course:</label>
        <form:select path="course" id="course">
            <form:option value="">-- Select Course --</form:option>
            <form:option value="Spring MVC">Spring MVC</form:option>
            <form:option value="Java">Java</form:option>
            <form:option value="Hibernate">Hibernate</form:option>
            <form:option value="React">React</form:option>
            <form:option value="English">English</form:option>
            <form:option value="Maths">Maths</form:option>
            <form:option value="Physical Education">Physical Education</form:option>
            <form:option value="Orthology">Orthology</form:option>
        </form:select>

        <label>Year:</label>
        <form:input id="year" path="year" type="number" placeholder="eg. 2024"/>

        <br/>
        <button type="submit" class="btn">Save Student</button>
        <a href="/students">Cancel</a>

    </form:form>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>