<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
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

        .cart-items {
            margin-bottom: 20px;
        }

        .cart-empty {
            text-align: center;
            font-size: 18px;
            color: #555;
        }

        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .cart-table th,
        .cart-table td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        .cart-table th {
            background-color: #f9f9f9;
        }

        .cart-action-btns {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .cart-action-btns form {
            display: inline-block;
            margin-right: 10px;
        }

        .cart-action-btns form:last-child {
            margin-right: 0;
        }

        .cart-action-btns input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }

        .cart-action-btns input[type="submit"]:hover {
            background-color: #0056b3;
        }
         .amount-to-pay {
                    text-align: center;
                    font-size: 18px;
                    font-weight: bold;
                    margin-bottom: 20px;
                }
         #amount {
                     text-align: center;
                     font-size: 18px;
                     font-weight: bold;
                     margin-bottom: 20px;
                 }
    </style>
</head>
<body>
<jsp:include page="../customer/header/header2.jsp" />

    <h1>Cart</h1>


    <div id="cart-items" class="cart-items">
        <h2>Cart Items</h2>
        <c:choose>
            <c:when test="${empty cartItems}">
                <p class="cart-empty">Cart is empty</p>
            </c:when>
            <c:otherwise>
                <table class="cart-table">
                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th> Total </th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iterate over cart items -->
                       <c:set var="totalCount" value="0" />
                       <c:set var="itemPrice" value="0" />
                       <c:forEach items="${cartItems}" var="item">
                           <tr>
                               <td>${item.book.title}</td>
                               <td>${item.book.price}</td>
                               <td>${item.quantity}</td>
                               <c:set var="itemPrice" value="${item.book.price * item.quantity}" />
                               <td>${itemPrice} Tk</td>
                               <td>
                                   <form action="../cartItems/update-quantity" method="post">
                                       <input type="hidden" name="bookId" value="${item.book.id}">
                                       <input type="number" name="quantity" value="1" min="1" max="${item.book.quantity}">
                                       <input type="submit" value="Update Quantity">
                                   </form>
                                   <form action="../cartItems/remove-book" method="post">
                                       <input type="hidden" name="bookId" value="${item.book.id}">
                                       <input type="submit" value="Remove">
                                   </form>
                               </td>
                           </tr>

                           <c:set var="totalCount" value="${totalCount + itemPrice}" />
                       </c:forEach>

                    </tbody>
                </table>
                <div id="process-button">
                <p id="amount">Amount To Pay: ${totalCount} TK</p>
                        <div class="cart-action-btns">

                            <form action="../orders/place-order" method="post">
                                <input type="hidden" name="totalprice" value=${totalCount}>
                                <input type="submit" value="Process">
                            </form>

                        </div>
                    </div>
            </c:otherwise>
        </c:choose>
    </div>


</body>
</html>
