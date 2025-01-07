package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    // Handles GET requests to display user profile
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the 'username' from the query parameter in the URL
        String username = request.getParameter("username");

        // Access the RegistrationServlet's users map using the servlet context
        // This allows us to share user data between servlets
        RegistrationServlet registrationServlet = (RegistrationServlet) getServletContext().getAttribute("registrationServlet");
        Map<String, String[]> users = registrationServlet.getUsers();

        // Check if the username is null or doesn't exist in the users map
        if (username == null || !users.containsKey(username)) {
            // If the user doesn't exist, show an error message
            // Provide a link to register a new user
            response.setContentType("text/html");
            response.getWriter().println("<h1 style='color: red;'>User not found!</h1>");
            response.getWriter().println("<a href='register.jsp'>Register Here</a>");
            return;  // Stop further processing as the user was not found
        }

        // Retrieve user details (password and email) for the given username
        // The user data is stored as an array with [0] as password and [1] as email
        String[] userDetails = users.get(username);
        String email = userDetails[1];  // Get the email from the array

        // Display the user profile page
        response.setContentType("text/html");
        response.getWriter().println("<h1>Banking System - User Profile</h1>");
        response.getWriter().println("<p><strong>Username:</strong> " + username + "</p>");
        response.getWriter().println("<p><strong>Email:</strong> " + email + "</p>");
        response.getWriter().println("<a href='register.jsp'>Register Another User</a>");
    }
}
