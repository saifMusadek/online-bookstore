<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    background-color:  maroon;
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
        <h1>Admin</h1>
    </div>

    <div id="tabs">
        <a href="dashboard" class="tab active">Dashboard</a>
        <a href="show-all-users" class="tab">Show All</a>
        <a href="edit-users" class="tab">Edit</a>
        <a href="show-delete" class="tab">Delete</a>
    </div>

<table>
  <tr>
    <th>ID</th>
    <th>Address</th>
    <th>Date of birth</th>
    <th>Email</th>
    <th>Gender</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Username</th>
    <th>Role</th>
    <th>Action</th>
  </tr>
  <c:forEach var="user" items="${userList}">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td>${user.phone}</td>
      <td>${user.address}</td>
      <td>${user.dob}</td>
      <td>${user.gender}</td>
        <td>
              <c:if test="${user.role.id eq 1}">
                Customer
              </c:if>
              <c:if test="${user.role.id eq 2}">
                              Admin
              </c:if>

            </td>
            <td><a href="delete/${user.id}" class="delete-button">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
