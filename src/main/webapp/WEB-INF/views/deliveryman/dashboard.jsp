<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delivery Man Dashboard</title>
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
        <h1>Delivery Man Dashboard</h1>
    </div>

    <div id="sidebar">
        <ul>
            <li><a href="<c:url value='/delivery/dashboard'/>">Dashboard</a></li>
            <li><a href="<c:url value='/delivery/orders'/>">My Orders</a></li>
            <li><a href="<c:url value='/delivery/orders-confirm'/>">Complete Order</a></li>
            <li><a href="<c:url value='/delivery/get-all'/>">Completed Orders</a></li>
             <li><a href="<c:url value='/logout'/>" class="tab">Logout</a></li>
        </ul>
    </div>

    <div id="content">
        <h2>Welcome, Delivery Man!</h2>
        <p>This is your dashboard. You can view and manage your orders, update your profile, and change settings from here.</p>
    </div>

    <div id="footer">
        &copy; 2023 Delivery Man Dashboard. All rights reserved.
    </div>
</body>
</html>
