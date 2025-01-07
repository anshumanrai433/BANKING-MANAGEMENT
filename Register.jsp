<!DOCTYPE html>
<html>
<head>
    <!-- Title of the page, displayed in the browser tab -->
    <title>User Registration</title>
</head>
<body>
    <!-- Main heading for the page -->
    <h1>Banking System - User Registration</h1>

    <!-- The form element that sends data to the RegisterServlet when the user submits it -->
    <form action="RegisterServlet" method="post">
        <!-- Label and input field for the username -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <!-- 'required' ensures that the user cannot submit the form without filling in the username -->
        <br><br>

        <!-- Label and input field for the password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <!-- 'type="password"' hides the entered characters for security -->
        <br><br>

        <!-- Label and input field for the email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <!-- 'type="email"' ensures that the input is in the proper email format -->
        <br><br>

        <!-- Submit button to send the form data to the server -->
        <button type="submit">Register</button>
    </form>
</body>
</html>
