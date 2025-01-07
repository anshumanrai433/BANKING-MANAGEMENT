package com.bankingsystem.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Servlet annotation to specify the URL pattern this servlet will handle
@WebServlet(name = "UserDisplayServlet", urlPatterns = "/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {

    // doGet method to handle HTTP GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Create a mock list of users (in a real-world application, 
        // this data would likely come from a database)
        List<User> users = new ArrayList<>();
        users.add(new User("Hasrh", "Hrsh@example.com"));  // Add a user with username and email
        users.add(new User("Harsh_raj", "jerr.doe@example.com")); // Add another user
        users.add(new User("Akka", "akka@example.com")); // Add a third user

        // Set the list of users as a request attribute to be accessed in the JSP
        request.setAttribute("userList", users);

        // Forward the request to the JSP page (displayUsers.jsp) for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayUsers.jsp");
        dispatcher.forward(request, response);
    }
}

// User class to hold user details such as username and email
class User {
    private String username;  // The user's username
    private String email;     // The user's email address

    // Constructor to initialize the username and email
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Getter method to retrieve the email
    public String getEmail() {
        return email;
    }
}
