package src.main.java.pojo;

public abstract class TradeAccount {
    private String id;

    // Constructor
    public TradeAccount(String id) {
        this.id = id;
    }

    // Getter
    public String getId() {
        return id;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public abstract TradeAccount clone();

}