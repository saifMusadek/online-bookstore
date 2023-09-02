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

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-weight: bold;
}

input[type="text"],
select {
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 50%; /* Adjust the width as needed */
    box-sizing: border-box;
}

button[type="submit"] {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

a.button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #ccc;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-decoration: none;
}

a.button:hover {
    background-color: #aaa;
}
</style>
</head>
<body>
<div id="header">
    <h1>DeliveryMan:  (see-all)</h1>
</div>

<div id="tabs">

     <a href="<c:url value='/delivery/dashboard'/>" class="tab active">Dashboard</a>


</div>

<table>
  <tr>
    <th>ID</th>
    <th>Order Number</th>


  </tr>
  <c:forEach var="d" items="${deliveryHistoryList}">
    <tr>
      <td>${d.id}</td>
      <td>${d.order.id}</td>
    </tr>
  </c:forEach>
</table>



</body>
</html>
