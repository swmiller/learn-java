package src.main.java.pojo;

import java.math.BigDecimal;

public class CashAccount extends TradeAccount {
    private BigDecimal cashBalance;

    public CashAccount(String id, BigDecimal cashBalance) {
        super(id);
        this.cashBalance = cashBalance;
    }

    public CashAccount(CashAccount source) {
        super(source.getId());
        this.cashBalance = source.cashBalance;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    @Override
    public TradeAccount clone() {
        return new CashAccount(this);
    }

}
