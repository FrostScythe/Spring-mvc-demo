<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Management System</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <h1>🎓 Student Management System</h1>

    <!-- Search Bar -->
    <div class="search-bar">
        <form action="/students/search" method="get">
            <input type="text" name="name"
                   placeholder="Search by name..."
                   value="${searchTerm}"/>
            <button type="submit">Search</button>
            <a href="/students">Clear</a>
        </form>
    </div>

    <!-- Info -->
    <p class="info">
        Total Students: <strong>${total}</strong>
        <c:if test="${searchTerm != null}">
            | Showing results for: <strong>"${searchTerm}"</strong>
        </c:if>
    </p>

    <!-- Add Button -->
    <a href="/students/add" class="btn">+ Add New Student</a>
    <br/><br/>

    <!-- Students Table -->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Year</th>
            <th>Action</th>
        </tr>
        <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td>${student.year}</td>
            <td>
                <%-- Edit button --%>
                <a href="/students/edit/${student.id}"
                   class="btn"
                   style="background:#2196F3; margin-right:5px;">
                   Edit
                </a>

                <%-- Delete button --%>
                <!-- Replace the delete <a> tag with this in both list.jsp files -->
                <form action="/students/delete/${student.id}" method="post" style="display:inline;">
                    <button type="submit"
                            onclick="return confirm('Delete ${student.name}?')"
                            class="btn btn-red"
                            style="padding:6px 12px; cursor:pointer;">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
        </c:forEach>

        <c:if test="${empty students}">
        <tr>
            <td colspan="6" style="text-align:center;">
                No students found.
            </td>
        </tr>
        </c:if>
    </table>

    <br/>
    <a href="/home" style="color:#888;">← Back to Home</a>

</body>
</html>