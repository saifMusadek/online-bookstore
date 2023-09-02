<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
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

        .order-details {
            margin-bottom: 20px;
        }

        .order-empty {
            text-align: center;
            font-size: 18px;
            color: #555;
        }

        .order-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .order-table th,
        .order-table td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        .order-table th {
            background-color: #f9f9f9;
        }

        .order-total {
            text-align: center;
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
 <jsp:include page="header/header.jsp" />
    <h1>Order Details</h1>

    <div id="order-details" class="order-details">
        <h2>Order Items</h2>
        <c:choose>
            <c:when test="${empty orderDetails}">
                <p class="order-empty">Order is empty</p>
            </c:when>
            <c:otherwise>
                <table class="order-table">
                    <thead>
                        <tr>
                            <th>Book Title</th>
                            <th>Book Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iterate over order details -->
                        <c:set var="totalCount" value="0" />
                        <c:set var="itemPrice" value="0" />
                        <c:forEach var="orderDetail" items="${orderDetails}">

                            <tr>
                                <td>${orderDetail.book.title}</td>
                                <td>${orderDetail.book.price}</td>

                                <td>${orderDetail.quantity}</td>
                                  <c:set var="itemPrice" value="${orderDetail.book.price * orderDetail.quantity}" />
                                  <td>${itemPrice}</td>
                            </tr>

                            <c:set var="totalCount" value="${totalCount + itemPrice}" />
                        </c:forEach>
                    </tbody>
                </table>
                <div class="order-total">
                    Amount paid ${totalCount} TK
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
