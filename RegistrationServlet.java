package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    // In-memory storage for registered users (username as key, password and email as values)
    private Map<String, String[]> users = new HashMap<>();

    // doPost method to handle the form submission for user registration
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user details from the form (username, password, and email)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Check if the username is already registered in the system
        if (users.containsKey(username)) {
            // If username exists, inform the user and allow them to go back to the registration page
            response.setContentType("text/html");
            response.getWriter().println("<h1 style='color: red;'>Username already exists!</h1>");
            response.getWriter().println("<a href='register.jsp'>Go Back</a>");
            return;  // Stop further processing since the registration failed
        }

        // Store the user's details in the 'users' map (password and email stored as an array)
        users.put(username, new String[]{password, email});

        // Redirect the user to their profile page after successful registration
        // The 'username' is passed as a query parameter to personalize the profile page
        response.sendRedirect("profile?username=" + username);
    }

    // Helper method to retrieve all registered users (for use in other servlets or for debugging)
    public Map<String, String[]> getUsers() {
        return users;
    }
}
