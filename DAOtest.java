package com.bankingsystem.dao;

import com.bankingsystem.models.BankAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankAccountDAOTest {
    // Declare an instance of the BankAccountDAO to be tested
    private BankAccountDAO bankAccountDAO;

    // Set up the test environment before each test is executed
    @Before
    public void setUp() {
        // Initialize the DAO object before each test
        bankAccountDAO = new BankAccountDAO();
    }

    // Test case to verify that a BankAccount can be saved correctly
    @Test
    public void testSave() {
        // Create a new BankAccount object to be saved
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);
        
        // Call the save method of the DAO to save the BankAccount
        BankAccount result = bankAccountDAO.save(account);

        // Assert that the result is not null (the account was saved)
        assertNotNull(result);
        
        // Assert that the account holder's name is correctly saved
        assertEquals("John Doe", result.getAccountHolderName());
        
        // Assert that the balance is correctly saved
        assertEquals(1000.0, result.getBalance(), 0);
    }

    // Test case to verify that multiple BankAccounts can be retrieved correctly
    @Test
    public void testFindAll() {
        // Save two BankAccount objects
        bankAccountDAO.save(new BankAccount(1, "John Doe", 1000.0));
        bankAccountDAO.save(new BankAccount(2, "Jane Doe", 2000.0));

        // Retrieve all saved BankAccounts
        List<BankAccount> accounts = bankAccountDAO.findAll();

        // Assert that the list of accounts is not null
        assertNotNull(accounts);
        
        // Assert that the correct number of accounts is returned
        assertEquals(2, accounts.size());
    }

    // Test case to verify that a BankAccount can be retrieved by its ID
    @Test
    public void testFindById() {
        // Save a BankAccount object
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);
        bankAccountDAO.save(account);

        // Retrieve the saved account by its ID
        BankAccount result = bankAccountDAO.findById(1);

        // Assert that the result is not null
        assertNotNull(result);
        
        // Assert that the retrieved account has the expected account holder name
        assertEquals("John Doe", result.getAccountHolderName());
    }

    // Test case to verify that a BankAccount can be deleted correctly
    @Test
    public void testDelete() {
        // Save a BankAccount object
        bankAccountDAO.save(new BankAccount(1, "John Doe", 1000.0));

        // Delete the account by its ID
        boolean result = bankAccountDAO.delete(1);

        // Assert that the deletion was successful
        assertTrue(result);

        // Assert that the account no longer exists
        assertNull(bankAccountDAO.findById(1));
    }
}
