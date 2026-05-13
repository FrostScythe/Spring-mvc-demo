<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Teacher</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

    <h1>✏️ Edit Teacher</h1>

    <form:form action="/teachers/edit/${teacher.id}"
               method="post"
               modelAttribute="teacher">

        <label>Name:</label>
        <form:input path="name"/>

        <label>Email:</label>
        <form:input path="email"/>

        <label>Subject:</label>
        <form:select path="subject">
            <form:option value="English">English</form:option>
            <form:option value="Spring">Spring</form:option>
            <form:option value="Hibernate">Hibernate</form:option>
            <form:option value="Electronic">Electronic</form:option>
            <form:option value="Communication">Communication</form:option>
        </form:select>

        <label>Department:</label>
        <form:select path="department">
            <form:option value="Information Technology">Information Technology</form:option>
            <form:option value="Electronic & Communication">Electronic & Communication</form:option>
            <form:option value="Literature">Literature</form:option>
            <form:option value="Mechanical">Mechanical</form:option>
        </form:select>

        <label>Experience (years):</label>
        <form:input path="experience" type="number"/>

        <label>Salary:</label>
        <form:input path="salary" type="number"/>

        <br/>
        <button type="submit" class="btn btn-blue">Update Teacher</button>
        <a href="/teachers" class="cancel">Cancel</a>

    </form:form>

</body>
</html>