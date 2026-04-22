<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Student</title>
    <style>
        body  { font-family: Arial, sans-serif; margin: 30px; }
        h1    { color: #333; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { padding: 8px; width: 300px; margin-top: 4px; }
        .btn  { margin-top: 16px; padding: 10px 20px;
                background: #2196F3; color: white;
                border: none; cursor: pointer; border-radius: 4px; }
        a     { margin-left: 12px; color: #888; }
    </style>
</head>
<body>

    <h1>✏️ Edit Student</h1>

    <%-- modelAttribute="student" binds to the Student object from controller --%>
    <form:form action="/students/edit/${student.id}"
               method="post"
               modelAttribute="student">

        <label>Name:</label>
        <form:input path="name"/>         <%-- pre-filled with existing name --%>

        <label>Email:</label>
        <form:input path="email"/>        <%-- pre-filled with existing email --%>

        <label>Course:</label>
        <form:select path="course">
            <form:option value="Spring MVC">Spring MVC</form:option>
            <form:option value="Java">Java</form:option>
            <form:option value="Hibernate">Hibernate</form:option>
            <form:option value="React">React</form:option>
        </form:select>

        <label>Year:</label>
        <form:input path="year" type="number"/>

        <br/>
        <button type="submit" class="btn">Update Student</button>
        <a href="/students">Cancel</a>

    </form:form>
</body>
</html>