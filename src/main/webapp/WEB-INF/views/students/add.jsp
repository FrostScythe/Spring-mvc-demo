<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Student</title>
    <style>
        body  { font-family: Arial, sans-serif; margin: 30px; }
        h1    { color: #333; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { padding: 8px; width: 300px; margin-top: 4px; }
        .btn  { margin-top: 16px; padding: 10px 20px;
                background: #4CAF50; color: white;
                border: none; cursor: pointer; border-radius: 4px; }
        a     { margin-left: 12px; color: #888; }
    </style>
</head>
<body>

    <h1>➕ Add New Student</h1>

    <form:form action="/students/add" method="post" modelAttribute="student">

        <label>Name:</label>
        <form:input path="name" placeholder="Enter Name"/>

        <label>Email:</label>
        <form:input path="email" placeholder="Enter Email"/>

        <label>Course:</label>
        <form:select path="course">
            <form:option value="">-- Select Course --</form:option>
            <form:option value="Spring MVC">Spring MVC</form:option>
            <form:option value="Java">Java</form:option>
            <form:option value="Hibernate">Hibernate</form:option>
            <form:option value="React">React</form:option>
        </form:select>

        <label>Year:</label>
        <form:input path="year" type="number" placeholder="Enter year"/>

        <br/>
        <button type="submit" class="btn">Save Student</button>
        <a href="/students">Cancel</a>

    </form:form>

</body>
</html>