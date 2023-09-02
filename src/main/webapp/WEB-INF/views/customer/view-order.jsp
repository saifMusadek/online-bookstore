<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .order-table {
            width: 100%;
            border-collapse: collapse;
        }

        .order-table th,
        .order-table td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .order-table th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        .order-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .order-table tr:hover {
            background-color: #e9e9e9;
        }

        .order-table td:first-child {
            width: 100px;
        }

        .order-table td:nth-child(2),
        .order-table td:nth-child(3),
        .order-table td:nth-child(4) {
            width: 150px;
        }

        .order-link {
            display: inline-block;
            width: 100%;
            height: 100%;
            text-decoration: none;
            color: inherit;
        }

        .order-link:hover {
            background-color: #e9e9e9;
        }
    </style>
</head>
<body>
 <jsp:include page="header/header.jsp" />

    <h1>Order History</h1>

    <table class="order-table">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Date</th>
                <th>Total</th>
                <th>Status</th>
                <th> Info</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${orderHistory}">

                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.totalPrice}</td>
                    <td>${order.orderStatus}</td>
                    <td><a href="../order-items/order-details/${order.id}">details</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
