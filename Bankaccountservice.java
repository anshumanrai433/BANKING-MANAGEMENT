package com.bankingsystem.services;

import com.bankingsystem.dao.BankAccountDAO;
import com.bankingsystem.models.BankAccount;

import java.util.List;

public class BankAccountService {
    // Declare an instance of the BankAccountDAO to interact with the database or data source
    private final BankAccountDAO bankAccountDAO;

    // Constructor to initialize the BankAccountDAO instance
    public BankAccountService(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    // Method to create a new bank account and save it using the DAO
    public BankAccount createAccount(BankAccount account) {
        return bankAccountDAO.save(account);
    }

    // Method to retrieve a list of all bank accounts from the DAO
    public List<BankAccount> getAllAccounts() {
        return bankAccountDAO.findAll();
    }

    // Method to retrieve a specific bank account by its ID
    public BankAccount getAccountById(int accountId) {
        return bankAccountDAO.findById(accountId);
    }

    // Method to delete a bank account by its ID using the DAO
    public boolean deleteAccount(int accountId) {
        return bankAccountDAO.delete(accountId);
    }
}
