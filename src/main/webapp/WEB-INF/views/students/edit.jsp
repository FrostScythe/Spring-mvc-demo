<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <h1>✏️ Edit Student</h1>

    <%-- modelAttribute="student" binds to the Student object from controller --%>
    <form:form action="/students/edit/${student.id}"
               method="post"
               modelAttribute="student" onsubmit="return validate()">

        <label>Name:</label>
        <form:input path="name" id="name"/>         <%-- pre-filled with existing name --%>

        <label>Email:</label>
        <form:input path="email" id="email"/>        <%-- pre-filled with existing email --%>

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
        <form:input id="year" path="year" type="number"/>

        <br/>
        <button type="submit" class="btn">Update Student</button>
        <a href="/students">Cancel</a>
    </form:form>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>