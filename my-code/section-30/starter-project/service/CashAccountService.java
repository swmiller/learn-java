package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService {

    private final TradeAccountRepository tradeAccountRepository;

    public CashAccountService(TradeAccountRepository repository) {
        this.tradeAccountRepository = repository;
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        // Find the account by ID
        CashAccount account = (CashAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            // Update the cash balance
            BigDecimal newBalance = account.getCashBalance().add(amount);
            account.setCashBalance(newBalance);
            // Save the updated account back to the repository
            tradeAccountRepository.updateTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        // Find the account by ID
        CashAccount account = (CashAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            // Check if there are sufficient funds
            if (account.getCashBalance().compareTo(amount) >= 0) {
                // Update the cash balance
                BigDecimal newBalance = account.getCashBalance().subtract(amount);
                account.setCashBalance(newBalance);
                // Save the updated account back to the repository
                tradeAccountRepository.updateTradeAccount(account);
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void createTradeAccount(CashAccount account) {
        if (account != null) {
            tradeAccountRepository.createTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    public CashAccount retrieveTradeAccount(String id) {
        CashAccount account = (CashAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            return account;
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void updateTradeAccount(CashAccount account) {
        if (account != null) {
            tradeAccountRepository.updateTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    public void deleteTradeAccount(String id) {
        CashAccount account = (CashAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            tradeAccountRepository.deleteTradeAccount(id);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}
