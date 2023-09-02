<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
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

        .user-profile {
            margin-bottom: 20px;
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
        }

        .profile-field {
            margin-bottom: 10px;
        }

        .field-label {
            font-weight: bold;
            color: #555;
        }

        .field-value {
            margin-left: 10px;
            color: #333;
        }
    </style>
</head>
<body>
 <jsp:include page="header/header.jsp" />
    <h1>User Profile</h1>

    <c:forEach var="user" items="${userDetails}">
        <div class="user-profile">
            <div class="profile-field">
                <span class="field-label">Name:</span>
                <span class="field-value">${user.name}</span>
            </div>
            <div class="profile-field">
                <span class="field-label">Email:</span>
                <span class="field-value">${user.email}</span>
            </div>
            <div class="profile-field">
                <span class="field-label">Username:</span>
                <span class="field-value">${user.username}</span>
            </div>
            <div class="profile-field">
                <span class="field-label">Gender:</span>
                <span class="field-value">${user.gender}</span>
            </div>
            <div class="profile-field">
                            <span class="field-label">Email:</span>
                            <span class="field-value">${user.email}</span>
                        </div>
             <div class="profile-field">
                <span class="field-label">Phone:</span>
                <span class="field-value">${user.phone}</span>
            </div>
             <div class="profile-field">
                <span class="field-label">Address:</span>
                <span class="field-value">${user.address}</span>
            </div>

            <!-- Add more profile fields as needed -->
        </div>
    </c:forEach>

</body>
</html>
