<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (errorMessage == null || errorMessage.isEmpty()) {
        errorMessage = "Something went wrong!";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="error-page">
    <div class="error-container">

        <div class="error-icon">⚠</div>

        <h1 class="error-title">
            Oops! Error Occurred
        </h1>

        <p class="error-message">
            <%= errorMessage %>
        </p>
        <a href="${backUrl}" class="error-btn">Go Back</a>

    </div>
</div>

</body>
</html>