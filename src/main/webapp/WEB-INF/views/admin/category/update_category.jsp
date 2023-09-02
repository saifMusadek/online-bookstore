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
    <h1>Admin: Category (edit)</h1>
</div>

<div id="tabs">

    <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
    <a href="show-category" class="tab">All Category</a>
    <a href="add-category" class="tab">Add Category</a>
    <a href="edit-category" class="tab">Edit Category</a>
    <a href="show-delete" class="tab">Delete Category</a>


</div>

<form action="<c:url value='/admin/category/search-category-edit'/>" method="POST">
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required/>
        <button type="submit">Search</button>
    </div>
    <div th:if="${errorMessage}" class="alert alert-danger" role="alert">
        <p th:text="${errorMessage}"></p>
    </div>
</form>

<form action="<c:url value='/admin/category/update-category'/>" method="POST">
    <input type="hidden" name="id" value="${category.id}"/>

    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="categoryName" value="${category.categoryName}" required/>
    </div>

    <div class="form-group">
        <button type="submit">Save</button>
        <a href="<c:url value='/admin/category/show-category'/>" class="button">Cancel</a>
    </div>
</form>
</body>
</html>
