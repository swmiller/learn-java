package src.main.java.pojo;

import java.math.BigDecimal;

public class MarginAccount extends TradeAccount {
    private BigDecimal margin;

    public MarginAccount(String id, BigDecimal margin) {
        super(id);
        this.margin = margin;
    }

    public MarginAccount(MarginAccount source) {
        super(source.getId());
        this.margin = source.margin;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    @Override
    public TradeAccount clone() {
        return new MarginAccount(this);
    }

}
