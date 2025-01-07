package com.bankingsystem.services;

import com.bankingsystem.dao.BankAccountDAO;
import com.bankingsystem.models.BankAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BankAccountServiceTest {

    // Mocked BankAccountDAO to simulate database interactions
    private BankAccountDAO bankAccountDAO;

    // Instance of the service class to be tested
    private BankAccountService bankAccountService;

    // Set up method that runs before each test to initialize the service and mock DAO
    @Before
    public void setUp() {
        // Mock the BankAccountDAO
        bankAccountDAO = mock(BankAccountDAO.class);

        // Create the BankAccountService object with the mocked DAO
        bankAccountService = new BankAccountService(bankAccountDAO);
    }

    // Test case to verify that a BankAccount is created properly
    @Test
    public void testCreateAccount() {
        // Create a new BankAccount to be saved
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);

        // Mock the DAO's save method to return the account when called
        when(bankAccountDAO.save(account)).thenReturn(account);

        // Call the createAccount method on the service
        BankAccount result = bankAccountService.createAccount(account);

        // Assert that the result is not null
        assertNotNull(result);

        // Assert that the account holder's name is correct
        assertEquals("John Doe", result.getAccountHolderName());

        // Assert that the balance is correct
        assertEquals(1000.0, result.getBalance(), 0);

        // Verify that the save method of the DAO was called exactly once
        verify(bankAccountDAO, times(1)).save(account);
    }

    // Test case to verify that all accounts are retrieved properly
    @Test
    public void testGetAllAccounts() {
        // Create a list of BankAccount objects to be returned by the DAO
        List<BankAccount> accounts = Arrays.asList(
                new BankAccount(1, "John Doe", 1000.0),
                new BankAccount(2, "Jane Doe", 2000.0)
        );

        // Mock the DAO's findAll method to return the list of accounts
        when(bankAccountDAO.findAll()).thenReturn(accounts);

        // Call the getAllAccounts method on the service
        List<BankAccount> result = bankAccountService.getAllAccounts();

        // Assert that the result is not null
        assertNotNull(result);

        // Assert that the size of the result is 2
        assertEquals(2, result.size());

        // Verify that the findAll method of the DAO was called exactly once
        verify(bankAccountDAO, times(1)).findAll();
    }

    // Test case to verify that a BankAccount can be retrieved by its ID
    @Test
    public void testGetAccountById() {
        // Create a BankAccount to be returned by the DAO
        BankAccount account = new BankAccount(1, "John Doe", 1000.0);

        // Mock the DAO's findById method to return the account when called with ID 1
        when(bankAccountDAO.findById(1)).thenReturn(account);

        // Call the getAccountById method on the service
        BankAccount result = bankAccountService.getAccountById(1);

        // Assert that the result is not null
        assertNotNull(result);

        // Assert that the account holder's name is correct
        assertEquals("John Doe", result.getAccountHolderName());

        // Verify that the findById method of the DAO was called exactly once with ID 1
        verify(bankAccountDAO, times(1)).findById(1);
    }

    // Test case to verify that a BankAccount is deleted properly
    @Test
    public void testDeleteAccount() {
        // Mock the DAO's delete method to return true when deleting account with ID 1
        when(bankAccountDAO.delete(1)).thenReturn(true);

        // Call the deleteAccount method on the service
        boolean result = bankAccountService.deleteAccount(1);

        // Assert that the deletion was successful (returns true)
        assertTrue(result);

        // Verify that the delete method of the DAO was called exactly once with ID 1
        verify(bankAccountDAO, times(1)).delete(1);
    }
}
