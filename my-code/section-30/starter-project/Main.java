import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

public class Main {

    static Path[] paths = new Path[] { Paths.get("data/accounts.txt"), Paths.get("data/transactions.txt") };

    static TradeAccountRepository tradeAccountRepository = new TradeAccountRepository();
    static CashAccountService cashAccountService = new CashAccountService(tradeAccountRepository);
    static MarginAccountService marginAccountService = new MarginAccountService(tradeAccountRepository);

    public static void main(String[] args) {
        try {
            loadTradeAccounts();
            applyTransactions();
            finalTest();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void finalTest() throws IOException {
        System.out.println(
                "Account A1234B Cash Balance: " + cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());
        System.out.println(
                "Account E3456F Cash Balance: " + cashAccountService.retrieveTradeAccount("E3456F").getCashBalance());
        System.out.println(
                "Account I5678J Cash Balance: " + cashAccountService.retrieveTradeAccount("I5678J").getCashBalance());
        System.out.println("Account C2345D Margin: " + marginAccountService.retrieveTradeAccount("C2345D").getMargin());
        System.out.println("Account G4567H Margin: " + marginAccountService.retrieveTradeAccount("G4567H").getMargin());
    }

    private static void applyTransactions() {
        try (var lines = java.nio.file.Files.lines(paths[1])) {
            lines.forEach(line -> {
                String[] parts = line.split("\\s");
                String accountType = parts[0].trim();
                String transactionType = parts[1].trim();
                String accountId = parts[2].trim();
                BigDecimal amount = new BigDecimal(parts[3].trim());

                if ("CASH".equalsIgnoreCase(accountType)) {
                    if ("DEPOSIT".equalsIgnoreCase(transactionType)) {
                        cashAccountService.deposit(accountId, amount);
                    } else if ("WITHDRAW".equalsIgnoreCase(transactionType)) {
                        cashAccountService.withdraw(accountId, amount);
                    }
                } else if ("MARGIN".equalsIgnoreCase(accountType)) {
                    if ("DEPOSIT".equalsIgnoreCase(transactionType)) {
                        marginAccountService.deposit(accountId, amount);
                    } else if ("WITHDRAW".equalsIgnoreCase(transactionType)) {
                        marginAccountService.withdraw(accountId, amount);
                    }
                }
            });
        } catch (Exception e) {
            System.err.println("Error applying transactions: " + e.getMessage());
        }
    }

    private static void loadTradeAccounts() {
        try (var lines = java.nio.file.Files.lines(paths[0])) {
            lines.forEach(line -> {
                String[] parts = line.split("\\s");
                String accountType = parts[0].trim();
                String accountId = parts[1].trim();
                BigDecimal balance = new BigDecimal(parts[2].trim());

                if ("CASH".equalsIgnoreCase(accountType)) {
                    cashAccountService.createTradeAccount(new CashAccount(accountId, balance));
                } else if ("MARGIN".equalsIgnoreCase(accountType)) {
                    marginAccountService.createTradeAccount(new MarginAccount(accountId, balance));
                }
            });
        } catch (Exception e) {
            System.err.println("Error loading trade accounts: " + e.getMessage());
        }
    }
}