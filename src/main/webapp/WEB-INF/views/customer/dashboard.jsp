<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard</title>
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

        .dashboard {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 20px;
        }

        .dashboard-item {
            background-color: #fff;
            border-radius: 4px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .dashboard-item h3 {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .dashboard-item p {
            font-size: 16px;
            margin-bottom: 10px;
        }

        .dashboard-item a {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            font-size: 14px;
            text-decoration: none;
            cursor: pointer;
        }

        .dashboard-item a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
     <jsp:include page="header/header.jsp" />
    <h1>Customer Dashboard</h1>

    <div class="dashboard">
        <div class="dashboard-item">
            <h3>Dashboard</h3>
            <a href="../customer/dashboard">Dashboard</a>
        </div><div class="dashboard-item">
            <h3>View Profile</h3>
            <a href="../customer/profile">View Profile</a>
        </div>
        <div class="dashboard-item">
            <h3>Edit Profile</h3>
            <a href="../customer/edit-profile">Edit Profile</a>
        </div>
        <div class="dashboard-item">
            <h3>View Orders</h3>
            <a href="../orders/view-orders">View Orders</a>
        </div>

        <!-- Add more dashboard items/buttons here -->
    </div>
</body>
</html>
