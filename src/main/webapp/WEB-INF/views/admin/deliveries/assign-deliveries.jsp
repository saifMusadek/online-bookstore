<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Deliveries</title>
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
    <h1>Assign Deliveries</h1>
</div>

<div id="tabs">

    <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
    <a href="<c:url value='/admin/show-pending-orders'/>" class="tab">Pending Orders</a>
    <a href="<c:url value='/admin/show-delivery-man'/>" class="tab">Delivery Man</a>
    <a href="<c:url value='/admin/assign-delivery-man'/>" class="tab">Assign Deliveries</a>

</div>

<div id="content">
    <form action="<c:url value='/admin/assigned-delivery-man'/>" method="post">
        <div class="form-group">
            <label for="deliveryMan">Select Delivery Man:</label>
            <select name="deliveryMan" id="deliveryMan">
                <option value="">Pick Delivery Man</option>
                <c:forEach var="deliveryMan" items="${deliverymanList}">
                    <option value="${deliveryMan.id}">${deliveryMan.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="order">Select Order:</label>
            <select name="order" id="order">
                <option value="">Pick Order</option>

                <c:forEach var="order" items="${orderList}">
                    <option value="${order.id}">${order.id}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Assign Delivery</button>
    </form>


            <c:if test="${not empty successMessage}">
                <p class="success-message">${successMessage}</p>
            </c:if>

            <c:if test="${not empty errorMessage}">
                <p class="error-message">${errorMessage}</p>
            </c:if>
        </div>

</div>
</body>
</html>
