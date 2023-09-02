<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: Author (Delete)</title>
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
        <h1>Admin: Author (Delete)</h1>
    </div>

    <div id="tabs">
        <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
        <a href="<c:url value='/admin/author/show-authors'/>" class="tab">All Authors</a>
        <a href="<c:url value='/admin/author/add-author'/>" class="tab">Add Author</a>
        <a href="<c:url value='/admin/author/edit-author'/>" class="tab">Edit Author</a>
        <a href="<c:url value='/admin/author/show-delete'/>" class="tab">Delete Author</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <c:forEach var="author" items="${authorList}">
            <tr>
                <td>${author.id}</td>
                <td>${author.authorName}</td>
                <td><a href="delete/${author.id}" class="delete-button">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
