<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Books</title>
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
            font-family: Arial, sans-serif;
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

        .book-cover {
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<div id="header">
    <h1>Admin: All Books</h1>
</div>

<div id="tabs">
      <a href="<c:url value='/admin/dashboard'/>" class="tab active">Dashboard</a>
        <a href="<c:url value='/admin/book/show-books'/>" class="tab">All Books</a>
        <a href="<c:url value='/admin/book/add-book'/>" class="tab">Add Books</a>
        <a href="<c:url value='/admin/book/edit-book'/>"class="tab">Edit Books</a>
        <a href="<c:url value='/admin/book/show-delete'/>" class="tab">Delete Books</a>

</div>

<div id="content">
   <table>
       <tr>
           <th>ID</th>
           <th>Title</th>
           <th>Author</th>
           <th>Category</th>
           <th>Description</th>
           <th>Price</th>
           <th>Quantity</th>
           <th>Cover</th>
       </tr>
       <c:forEach var="book" items="${bookList}">
           <tr>
               <td>${book.id}</td>
               <td>${book.title}</td>
               <td><c:forEach var="author" items="${authorList}">
                                          <c:if test="${book.author.id == author.id}">
                                              ${author.authorName}
                                          </c:if>
                                      </c:forEach></td>
               <td>
                   <c:forEach var="category" items="${categoryList}">
                       <c:if test="${book.category.id == category.id}">
                           ${category.categoryName}
                       </c:if>
                   </c:forEach>
               </td>
               <td>${book.description}</td>
               <td>${book.price}</td>
               <td>${book.quantity}</td>
               <td>
                   <img src="/final/ReachResourceFolder/images/${book.cover}" alt="Book Cover" class="book-cover">
               </td>


           </tr>
       </c:forEach>
   </table>
</div>
</body>
</html>
