<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Add Teacher</title>
        <style>
            body  { font-family: Arial, sans-serif; margin: 30px; }
            h1    { color: #333; }
            label { display: block; margin-top: 12px; font-weight: bold; }
            input, select { padding: 8px; width: 300px; margin-top: 4px; }
            .btn  { margin-top: 16px; padding: 10px 20px;
                    background: #4CAF50; color: white;
                    border: none; cursor: pointer; border-radius: 4px; }
            a { margin-left: 12px; color: #888; }
        </style>
    </head>
    <body>
         <h1>Add New Teacher ➕</h1>
        <form:form action="/teachers/add" method ="post" modelAttribute="teacher">
            <label>Name:</label>
            <form:input path="name" placeholder="Enter Name"/>

            <label>Email:</label>
            <form:input path"email" placeholder="Enter Email" />

            <label> Subject: </label>
            <form:select path="subject">
                <form:option value="">--Select Subject --</form:option>
                <form:option value="English">English</form:option>
                <form:option value="Spring">Spring</form:option>
                <form:option value="Hibernate">Hibernate</form:option>
                <form:option value="Electronic">Electronic</form:option>
                <form:option value="Communication">Communication</form:option>
        <form:form>

            <label> Department </label>
              <form:select path="department">
               <form:option value="">--Select Department --</form:option>
               <form:option value="Information Technology">Information Technology</form:option>
               <form:option value="Electronic & Communication">Electronic & Communication</form:option>
               <form:option value="Literature">Literature</form:option>
               <form:option value="Mechanical">Mechanical</form:option>
              <form:form>

          <label>Experience</label>
          <form:input path="experience" type="number" placeholder="Enter experience"/>
          <form:input path="salary" type="number" placeholder="Enter salary"/>

          <br/>
                  <button type="submit" class="btn">Save Teacher</button>
                  <a href="/teachers">Cancel</a>
    </body>
</html>