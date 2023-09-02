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
        <h1>Admin: Category (Delete)</h1>
    </div>

 <div id="tabs">

     <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
     <a href="show-category" class="tab">All Category</a>
     <a href="add-category" class="tab">Add Category</a>
     <a href="edit-category" class="tab">Edit Category</a>
     <a href="show-delete" class="tab">Delete Category</a>


 </div>

<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Action</th>
  </tr>
  <c:forEach var="category" items="${categoryList}">
    <tr>
      <td>${category.id}</td>
      <td>${category.categoryName}</td>
      <td><a href="delete/${category.id}" class="delete-button">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
