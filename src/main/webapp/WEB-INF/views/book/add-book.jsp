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

/* Style for file upload button */
.file-upload {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    background-color: #555;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.file-upload:hover {
    background-color: #333;
}

.file-input {
    display: none;
}

/* Style for input fields */
.input-field {
    width: 50%;
}

/* Style for specific input fields */
.input-field.price,
.input-field.quantity {
    height: 80px; /* Adjust the height as needed */
}
</style>
</head>
<body>
<div id="header">
    <h1>Admin: Admin (add-book)</h1>
</div>

<div id="tabs">

    <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
    <a href="<c:url value='/admin/book/show-books'/>" class="tab">All Books</a>
    <a href="<c:url value='/admin/book/add-book'/>" class="tab">Add Books</a>
    <a href="<c:url value='/admin/book/edit-book'/>"class="tab">Edit Books</a>
    <a href="<c:url value='/admin/book/show-delete'/>" class="tab">Delete Books</a>


</div>

<h1>Add Book</h1>
<form action="<c:url value='add-book-db'/>" method="POST" enctype="multipart/form-data">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required class="input-field"><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required class="input-field"></textarea><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required class="input-field price"><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" required class="input-field quantity"><br>

    <label for="author">Author:</label>
    <select id="authorName" name="author_id" multiple required class="input-field">
        <c:forEach var="a" items="${authorList}">
            ${c.categoryName}
            <option value="${a.id}">${a.authorName}</option>
        </c:forEach>
    </select><br>

    <label for="categories">Categories:</label>
    <select id="categories" name="category_id" multiple required class="input-field">
        <c:forEach var="c" items="${categoryList}">
            ${c.categoryName}
            <option value="${c.id}">${c.categoryName}</option>
        </c:forEach>
    </select><br>

    <!-- Add category id and author id -->
    <label for="cover">Book Cover:</label>
    <input type="file" name="cover" accept=".jpg, .jpeg, .png" />
        <br>

    <button type="submit">Add Book</button>
</form>
</body>
</html>
