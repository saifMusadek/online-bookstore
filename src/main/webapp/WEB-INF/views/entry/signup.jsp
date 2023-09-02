<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }

        h1 {
            text-align: center;
            margin-top: 30px;
        }

        form {
            max-width: 400px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        textarea,
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Registration Form</h1>
    <form:form modelAttribute="user" method="POST" action="signup">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <form:errors path="name" cssClass="error" />

        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        <form:errors path="username" cssClass="error" />

        <label for="password">Password:</label>
        <form:password path="password" id="password" />
        <form:errors path="password" cssClass="error" />

        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword">

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender">
        <form:errors path="gender" cssClass="error" />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        <form:errors path="email" cssClass="error" />

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone">
        <form:errors path="phone" cssClass="error" />

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob">
        <form:errors path="dob" cssClass="error" />

        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="3"></textarea>
        <form:errors path="address" cssClass="error" />

        <input type="submit" value="Register">
    </form:form>
</body>
</html>
