package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

public class TradeAccountServiceTest {

    private TradeAccountRepository repository;
    private CashAccountService cashAccountService;
    private MarginAccountService marginAccountService;

    @BeforeEach
    public void setup() {
        repository = new TradeAccountRepository();
        cashAccountService = new CashAccountService(repository);
        marginAccountService = new MarginAccountService(repository);
    }

    @Test
    public void testCashAccountDeposit() {
        CashAccount account = new CashAccount("A1234B", BigDecimal.valueOf(500.00));
        cashAccountService.createTradeAccount(account);

        cashAccountService.deposit("A1234B", BigDecimal.valueOf(100.00));
        assertEquals(BigDecimal.valueOf(600.00), cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());
    }

    @Test
    public void testCashAccountWithdraw() {
        CashAccount account = new CashAccount("A1234B", BigDecimal.valueOf(500.00));
        cashAccountService.createTradeAccount(account);

        cashAccountService.withdraw("A1234B", BigDecimal.valueOf(200.00));
        assertEquals(BigDecimal.valueOf(300.00), cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());
    }

    @Test
    public void testMarginAccountDeposit() {
        MarginAccount account = new MarginAccount("C2345D", BigDecimal.valueOf(0.50));
        marginAccountService.createTradeAccount(account);

        marginAccountService.deposit("C2345D", BigDecimal.valueOf(100.00));
        assertEquals(BigDecimal.valueOf(100.50), marginAccountService.retrieveTradeAccount("C2345D").getMargin());
    }

    @Test
    public void testMarginAccountWithdraw() {
        MarginAccount account = new MarginAccount("C2345D", BigDecimal.valueOf(200.00));
        marginAccountService.createTradeAccount(account);

        marginAccountService.withdraw("C2345D", BigDecimal.valueOf(50.00));
        assertEquals(BigDecimal.valueOf(150.00), marginAccountService.retrieveTradeAccount("C2345D").getMargin());
    }

    @Test
    public void testInsufficientFundsWithdraw() {
        CashAccount account = new CashAccount("A1234B", BigDecimal.valueOf(100.00));
        cashAccountService.createTradeAccount(account);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cashAccountService.withdraw("A1234B", BigDecimal.valueOf(200.00));
        });

        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testCreateDuplicateAccount() {
        CashAccount account = new CashAccount("A1234B", BigDecimal.valueOf(500.00));
        cashAccountService.createTradeAccount(account);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cashAccountService.createTradeAccount(account);
        });

        assertEquals("Trade account already exists or is null", exception.getMessage());
    }

    @Test
    public void testDeleteAccount() {
        MarginAccount account = new MarginAccount("C2345D", BigDecimal.valueOf(100.00));
        marginAccountService.createTradeAccount(account);

        marginAccountService.deleteTradeAccount("C2345D");
        assertNull(marginAccountService.retrieveTradeAccount("C2345D"));
    }
}
