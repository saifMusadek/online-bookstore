<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Header</title>
    <!-- Add CSS styles or link to external CSS file if needed -->
    <style>
        /* CSS styles for the header */
        .header {
            background-color: #f5f5f5;
            padding: 20px;
            text-align: right;
        }

        .header a {
            margin-right: 10px;
            text-decoration: none;
            color: #007bff;
        }

        .logout-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            font-size: 14px;
            text-decoration: none;
            cursor: pointer;
        }

        .logout-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <!-- Add the logout button -->


        <a href="../market/get-market">Market </a>
        <a href="../cart/view-cart">Cart </a>
        <a href="../login">Login </a>
         <a href="../signup">Signup</a>




    </div>
</body>
</html>
