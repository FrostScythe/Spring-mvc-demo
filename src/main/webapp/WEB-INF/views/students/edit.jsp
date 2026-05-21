<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setAttribute("pageTitle", "Edit Student — SchoolMS"); %>
<% request.setAttribute("currentPage", "students"); %>
<%@ include file="../common/header.jsp" %>

    <div class="page-header">
        <div>
            <h1>✏️ Edit Student</h1>
            <div class="page-subtitle">Update student details</div>
        </div>
        <a href="/students" class="btn btn-ghost">← Back to Students</a>
    </div>

    <div class="form-card">
        <form:form action="/students/edit/${student.id}"
                   method="post"
                   modelAttribute="student"
                   onsubmit="return validate()">

            <div class="form-group">
                <label>Name</label>
                <form:input id="name" path="name"/>
            </div>

            <div class="form-group">
                <label>Email</label>
                <form:input id="email" path="email"/>
            </div>

            <div class="form-group">
                <label>Course</label>
                <form:select id="course" path="course">
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
            </div>

            <div class="form-group">
                <label>Year</label>
                <form:input id="year" path="year" type="number"/>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Update Student</button>
                <a href="/students" class="btn btn-ghost">Cancel</a>
            </div>

        </form:form>
    </div>

    <script src="${pageContext.request.contextPath}/js/script.js"></script>

<%@ include file="../common/footer.jsp" %>
