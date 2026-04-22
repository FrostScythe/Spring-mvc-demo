<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Management System</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        h1   { color: #333; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        a.btn { padding: 6px 12px; background: #4CAF50;
                color: white; text-decoration: none; border-radius: 4px; }
        a.btn-red { background: #e53935; }
        .search-bar { margin: 15px 0; }
        .search-bar input { padding: 8px; width: 250px; }
        .search-bar button { padding: 8px 16px; background: #2196F3;
                             color: white; border: none; cursor: pointer; }
        .info { color: #555; margin-bottom: 10px; }
    </style>
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
                <a href="/teachers/delete/${teacher.id}"
                   class="btn btn-red"
                   onclick="return confirm('Delete ${teacher.name}?')">
                   Delete
                </a>
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