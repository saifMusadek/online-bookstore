<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
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

        #sidebar {
            background-color: #555;
            color: #fff;
            padding: 20px;
            width: 200px;
            float: left;
        }

        #content {
            margin-left: 220px;
            padding: 20px;
        }

        #footer {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
            clear: both;
        }
    </style>
</head>
<body>
    <div id="header">
        <h1>Admin Dashboard</h1>
    </div>

    <div id="sidebar">
        <ul>
            <li><a href="<c:url value='/admin/dashboard'/>">Dashboard</a></li>
            <li><a href="show-all-users">Users</a></li>
            <li><a href="<c:url value='/admin/book/show-books'/>">Books</a></li>
            <li><a href="<c:url value='/admin/category/show-category'/>">Catagories</a></li>
            <li><a href = "<c:url value='/admin/author/show-authors'/>">Authors</li>
            <li><a href="<c:url value='/admin/show-pending-orders'/>" class="tab">Deliveries And Orders</a></li>
            <li><a href="<c:url value='/logout'/>" class="tab">Logout</a></li>


        </ul>
    </div>

    <div id="content">
        <h2>Welcome, Admin!</h2>
        <p>This is the admin dashboard. You can manage users, products, orders, and settings from here.</p>
    </div>

    <div id="footer">
        &copy; 2023 Admin Dashboard. All rights reserved.
    </div>
</body>
</html>
