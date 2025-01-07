<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- This line sets the content type of the page to HTML and character encoding to UTF-8, 
     and specifies that the page uses Java for its language -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- This imports the JSTL (JavaServer Pages Standard Tag Library) core tag library, 
     allowing us to use tags like <c:forEach> for iteration in the page -->

<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <style>
        /* Styling for the table */
        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        /* Styling for table header (th) and table data (td) */
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        /* Background color for table header */
        th {
            background-color: #f4f4f4;
        }

        /* Styling for the main heading */
        h1 {
            text-align: center;
        }

        /* Styling for the link to the registration page */
        a {
            display: block;
            text-align: center;
            margin: 20px;
        }
    </style>
</head>
<body>
    <!-- Main heading of the page -->
    <h1>Registered Users</h1>

    <!-- Table to display the user list -->
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <!-- JSTL <c:forEach> tag to loop through the userList object -->
            <c:forEach var="user" items="${userList}">
                <tr>
                    <!-- Display each user's username and email in the table -->
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Link to the registration page where users can add a new user -->
    <a href="register.jsp">Register a New User</a>
</body>
</html>
