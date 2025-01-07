package com.bankingsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BankingServlet", urlPatterns = "/banking")
public class BankingServlet extends HttpServlet {

    // Sample data for demonstration - Account holder name and balance
    private String accountHolderName = "John Doe";
    private double accountBalance = 1000.0;

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Display the account overview (account holder and balance)
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Banking Management System</h1>");
            out.println("<h2>Account Details:</h2>");
            out.println("<p><strong>Account Holder:</strong> " + accountHolderName + "</p>");
            out.println("<p><strong>Account Balance:</strong> $" + accountBalance + "</p>");
            out.println("<br>");

            // Display a form to allow user to choose transaction type (Deposit or Withdraw)
            out.println("<form method='POST' action='/banking'>");
            out.println("<label for='transactionType'>Transaction Type:</label>");
            out.println("<select name='transactionType' id='transactionType'>");
            out.println("<option value='deposit'>Deposit</option>");
            out.println("<option value='withdraw'>Withdraw</option>");
            out.println("</select>");
            out.println("<br><label for='amount'>Amount:</label>");
            out.println("<input type='number' name='amount' id='amount' required>");
            out.println("<br><button type='submit'>Submit</button>");
            out.println("</form>");
        }
    }

    // Handles POST requests (form submission for transactions)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form data - Transaction type (Deposit/Withdraw) and amount
        String transactionType = request.getParameter("transactionType");
        String amountStr = request.getParameter("amount");

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Banking Management System</h1>");
            out.println("<h2>Transaction Summary:</h2>");

            // Validate and process the transaction based on the transaction type
            try {
                // Parse the amount entered by the user
                double amount = Double.parseDouble(amountStr);

                // Handle deposit transaction
                if ("deposit".equalsIgnoreCase(transactionType)) {
                    accountBalance += amount;  // Add the amount to the account balance
                    out.println("<p><strong>Transaction:</strong> Deposit</p>");
                }
                // Handle withdraw transaction
                else if ("withdraw".equalsIgnoreCase(transactionType)) {
                    // Check if sufficient balance is available for withdrawal
                    if (amount > accountBalance) {
                        out.println("<p style='color: red;'>Error: Insufficient balance!</p>");
                        out.println("<p><strong>Current Balance:</strong> $" + accountBalance + "</p>");
                        return; // Stop further processing if balance is insufficient
                    }
                    accountBalance -= amount;  // Subtract the amount from the account balance
                    out.println("<p><strong>Transaction:</strong> Withdrawal</p>");
                }
                // Handle invalid transaction type
                else {
                    out.println("<p style='color: red;'>Invalid transaction type.</p>");
                    return;  // Stop processing if the transaction type is invalid
                }

                // Display the transaction amount and the updated account balance
                out.println("<p><strong>Transaction Amount:</strong> $" + amount + "</p>");
                out.println("<p><strong>Updated Balance:</strong> $" + accountBalance + "</p>");
            } catch (NumberFormatException e) {
                // Handle invalid input for the amount (non-numeric)
                out.println("<p style='color: red;'>Invalid amount entered. Please enter a numeric value.</p>");
            }

            // Provide a link to go back to the account overview page
            out.println("<br><a href='/banking'>Go Back to Account Overview</a>");
        }
    }
}
