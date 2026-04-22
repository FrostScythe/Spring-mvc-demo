<%-- index.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
            text-align: center;
            width: 300px;
        }

        h2 {
            margin-bottom: 25px;
            color: #333;
        }

        a {
            display: block;
            margin: 10px 0;
            padding: 12px;
            text-decoration: none;
            color: white;
            background: #4facfe;
            border-radius: 8px;
            transition: 0.3s;
            font-weight: bold;
        }

        a:hover {
            background: #007bff;
            transform: scale(1.05);
        }
    </style>
</head>

<body>
    <div class="card">
        <h2>Welcome 👋</h2>
        <a href="/students">Go to Students</a>
        <a href="/teachers">Go to Teachers</a>
    </div>
</body>
</html>