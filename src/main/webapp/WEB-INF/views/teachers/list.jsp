<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Management System</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>

    <h1>👨‍🏫 Teacher Management System</h1>

    <!-- Search Bar -->
    <div class="search-bar">
        <form action="/teachers/search" method="get">
            <input type="text" name="name"
                   placeholder="Search by name..."
                   value="${searchTerm}"/>
            <button type="submit">Search</button>
            <a href="/teachers">Clear</a>
        </form>
    </div>

    <!-- Info -->
    <p class="info">
        Total Teachers: <strong>${total}</strong>
        <c:if test="${searchTerm != null}">
            | Showing results for: <strong>"${searchTerm}"</strong>
        </c:if>
    </p>

    <!-- Add Button -->
    <a href="/teachers/add" class="btn">+ Add New Teacher</a>
    <br/><br/>

    <!-- Teachers Table -->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Subject</th>
            <th>Department</th>
            <th>Experience</th>
            <th>salary</th>
            <th>Action</th>
        </tr>
        <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.email}</td>
            <td>${teacher.subject}</td>
            <td>${teacher.department}</td>
            <td>${teacher.experience}</td>
            <td>${teacher.salary}</td>
            <td>
             <%-- Edit button --%>
            <a href="/teachers/edit/${teacher.id}"
                               class="btn"
                               style="background:#2196F3; margin-right:5px;">Edit</a>

                <%-- Delete button --%>
                <form action="/teachers/delete/${teacher.id}" method="post" style="display:inline;">
                    <button type="submit"
                            onclick="return confirm('Delete ${teacher.name}?')"
                            class="btn btn-red"
                            style="padding:6px 12px; cursor:pointer;">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
        </c:forEach>

        <c:if test="${empty teachers}">
        <tr>
            <td colspan="6" style="text-align:center;">
                No teacher found.
            </td>
        </tr>
        </c:if>
    </table>

    <br/>
    <a href="/home" style="color:#888;">← Back to Home</a>

</body>
</html>