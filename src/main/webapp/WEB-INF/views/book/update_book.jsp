<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: Book (edit)</title>
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
    <h1>Admin: Book (edit)</h1>
</div>

<div id="tabs">
  <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
    <a href="<c:url value='/admin/book/show-books'/>" class="tab">All Books</a>
    <a href="<c:url value='/admin/book/add-book'/>" class="tab">Add Books</a>
    <a href="<c:url value='/admin/book/edit-book'/>"class="tab">Edit Books</a>
    <a href="<c:url value='/admin/book/show-delete'/>" class="tab">Delete Books</a>

</div>

<form action="<c:url value='/admin/book/search-book-edit'/>" method="POST">
    <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required/>
        <button type="submit">Search</button>
    </div>
    <div th:if="${errorMessage}" class="alert alert-danger" role="alert">
        <p th:text="${errorMessage}"></p>
    </div>
</form>

<form action="<c:url value='/admin/book/update-book'/>" method="POST">
    <input type="hidden" name="id" value="${book.id}"/>

    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}" required/>
    </div>

    <div class="form-group">
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${book.author.id}" required/>
    </div>

    <div class="form-group">
        <label for="category">Category:</label>
        <select id="category" name="category" required>
            <option value="" selected disabled>Select a category</option>
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}" ${category.id == book.category.id ? 'selected' : ''}>${category.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${book.price}" required/>
    </div>


    <div class="form-group">
        <button type="submit">Save</button>
        <a href="<c:url value='/admin/book/show-books'/>" class="button">Cancel</a>
    </div>
</form>
</body>
</html>
