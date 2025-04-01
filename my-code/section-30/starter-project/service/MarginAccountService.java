package service;

import java.math.BigDecimal;

import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService {

    private final TradeAccountRepository tradeAccountRepository;

    public MarginAccountService(TradeAccountRepository repository) {
        this.tradeAccountRepository = repository;
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        // Find the account by ID
        MarginAccount account = (MarginAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            // Update the margin
            BigDecimal newMargin = account.getMargin().add(amount);
            account.setMargin(newMargin);
            // Save the updated account back to the repository
            tradeAccountRepository.updateTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        // Find the account by ID
        MarginAccount account = (MarginAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            // Check if there are sufficient funds
            if (account.getMargin().compareTo(amount) >= 0) {
                // Update the margin
                BigDecimal newMargin = account.getMargin().subtract(amount);
                account.setMargin(newMargin);
                // Save the updated account back to the repository
                tradeAccountRepository.updateTradeAccount(account);
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void createTradeAccount(MarginAccount account) {
        if (account != null) {
            tradeAccountRepository.createTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    public MarginAccount retrieveTradeAccount(String id) {
        MarginAccount account = (MarginAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            return account;
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void updateTradeAccount(MarginAccount account) {
        if (account != null) {
            tradeAccountRepository.updateTradeAccount(account);
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    public void deleteTradeAccount(String id) {
        MarginAccount account = (MarginAccount) tradeAccountRepository.retrieveTradeAccount(id);
        if (account != null) {
            tradeAccountRepository.deleteTradeAccount(id);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}