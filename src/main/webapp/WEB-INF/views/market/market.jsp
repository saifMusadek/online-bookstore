<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Marketplace</title>
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

        .book-list {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 20px;
        }

        .book-item {
            background-color: #fff;
            border-radius: 4px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .book-title {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .book-price {
            font-size: 16px;
            margin-bottom: 10px;
        }

        .add-to-cart-btn {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }

        .add-to-cart-btn:hover {
            background-color: #0056b3;
        }

        .cart-icon {
            position: fixed;
            top: 20px;
            right: 20px;
            width: 40px;
            height: 40px;
            background-color: #007bff;
            color: #fff;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 18px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<jsp:include page="../customer/header/header2.jsp" />
    <h1>Book Marketplace</h1>

    <div class="book-list">
        <c:forEach var="book" items="${books}">
            <div class="book-item">
                <h3 class="book-title">${book.title}</h3>
                <p class="book-price">${book.price} ৳</p>
                <p class="book-price">Left : ${book.quantity}</p>

                <c:set var="addedToCart" value="false" />
                <c:forEach items="${cartItems}" var="item">
                    <c:if test="${item.book.id == book.id}">
                        <c:set var="addedToCart" value="true" />
                    </c:if>
                </c:forEach>

                <!-- Display the message based on whether the book is added to the cart -->
                <c:if test="${addedToCart}">
                    <p style="color: red">Book added to cart</p>
                </c:if>
                <c:if test="${not addedToCart}">
                    <!-- Check if there is an error message for this book -->
                    <c:if test="${not empty errorMessageMap[book.id]}">
                        <p style="color: red">${errorMessageMap[book.id]}</p>
                    </c:if>
                    <c:if test="${empty errorMessageMap[book.id]}">
                        <form action="./post-market" method="post">
                            <input type="hidden" name="bookId" value="${book.id}">
                            <input type="submit" class="add-to-cart-btn" value="Add to Cart">
                        </form>
                    </c:if>
                </c:if>
            </div>
        </c:forEach>
    </div>

    <a href="../cart/view-cart" class="cart-icon">Cart</a>
</body>
</html>
