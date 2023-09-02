<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f1f1f1;
}

#header {
    background-color: #333;
    color: #fff;
    padding: 20px;
    text-align: center;
}

#tabs {
    margin-top: 20px;
    text-align: center;
}

.tab {
    display: inline-block;
    padding: 10px 20px;
    background-color: #555;
    color: #fff;
    text-decoration: none;
    margin-right: 10px;
    border-radius: 4px;
}

.tab.active {
    background-color: #333;
}

#content {
    margin-top: 20px;
    padding: 20px;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-weight: bold;
}

input[type="text"],
select {
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 50%; /* Adjust the width as needed */
    box-sizing: border-box;
}

button[type="submit"] {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

a.button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #ccc;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-decoration: none;
}

a.button:hover {
    background-color: #aaa;
}
</style>
</head>
<body>
<div id="header">
    <h1>Admin: Edit User</h1>
</div>

<div id="tabs">
    <a href="dashboard" class="tab active">Dashboard</a>
    <a href="show-all-users" class="tab">Show All</a>
    <a href="edit-users" class="tab">Edit</a>
    <a href="show-delete" class="tab">Delete</a>
</div>

<form action="<c:url value='/admin/search-users-edit'/>" method="POST">
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required/>
        <button type="submit">Search</button>
    </div>
    <div th:if="${errorMessage}" class="alert alert-danger" role="alert">
        <p th:text="${errorMessage}"></p>
    </div>
</form>

<form action="<c:url value='/admin/update-user'/>" method="POST">
    <input type="hidden" name="id" value="${user.id}"/>

    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required/>
    </div>
    <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required/>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${user.email}" required/>
    </div>

    <div class="form-group">
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" required/>
    </div>

    <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${user.address}" required/>
    </div>

    <div class="form-group">
        <label for="dob">dob:</label>
        <input type="text" id="dob" name="dob" value="${user.dob}" required/>
    </div>

    <div class="form-group">
        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" value="${user.gender}" required/>
    </div>

    <div class="form-group">
        <label for="role">Role:</label>
        <label for="role"><c:if test="${user.role.id eq 1}">Customer</c:if>
        <input type="int" id="role_id" name="role_id" value="${user.role.id}" required/>
            <c:if test="${user.role.id eq 2}">
                Admin
            </c:if></label>
    </div>

    <div class="form-group">
        <button type="submit">Save</button>
        <a href="<c:url value='/admin/show-all-users'/>" class="button">Cancel</a>
    </div>
</form>
</body>
</html>
