package com.bankingsystem.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserDisplayServlet", urlPatterns = "/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {

    // In-memory data structure to store mock user information (username, password, and email)
    private static final Map<String, String[]> users = new HashMap<>();

    // Static block to initialize mock user data
    static {
        // Adding some mock users with their password and email information
        users.put("Harsh", new String[]{"password123", "Harsh.doe@example.com"});
        users.put("Harsh_raj", new String[]{"password456", "raj.doe@example.com"});
    }

    // doGet method to handle HTTP GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the user data (the map of users) as a request attribute
        request.setAttribute("users", users);

        // Forward the request to the JSP page for displaying the users
        // The request will be forwarded to 'displayUsers.jsp', where the data will be rendered
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayUsers.jsp");
        dispatcher.forward(request, response);
    }
}
