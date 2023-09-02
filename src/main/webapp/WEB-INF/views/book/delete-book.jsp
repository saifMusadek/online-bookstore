<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: Book (delete)</title>
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

    .delete-button {
        padding: 10px 20px;
        font-size: 16px;
        background-color: maroon;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
    }

    .delete-button:hover {
        background-color: #800000;
    }
</style>
</head>
<body>
    <div id="header">
        <h1>Admin: Book (delete)</h1>
    </div>

    <div id="tabs">
            <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
               <a href="<c:url value='/admin/book/show-books'/>" class="tab">All Books</a>
               <a href="<c:url value='/admin/book/add-book'/>" class="tab">Add Books</a>
               <a href="<c:url value='/admin/book/edit-book'/>"class="tab">Edit Books</a>
               <a href="<c:url value='/admin/book/show-delete'/>" class="tab">Delete Books</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>Publication Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author.id}</td>
                <td>${book.category.id}</td>
                <td>${book.price}</td>
                <td><a href="<c:url value='/admin/book/delete/${book.id}'/>" class="delete-button">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
