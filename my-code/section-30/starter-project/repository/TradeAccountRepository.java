package repository;

import java.util.HashMap;
import java.util.Map;

import pojo.TradeAccount;

public class TradeAccountRepository {
    private Map<String, TradeAccount> datastore = new HashMap<>();

    public TradeAccountRepository() {
        this.datastore = new HashMap<>();
    }

    public void createTradeAccount(TradeAccount tradeAccount) {
        if (tradeAccount != null && !datastore.containsKey(tradeAccount.getId())) {
            datastore.put(tradeAccount.getId(), tradeAccount.clone());
        } else {
            throw new IllegalArgumentException("Trade account already exists or is null");
        }
    }

    public TradeAccount retrieveTradeAccount(String id) {
        return this.datastore.get(id) == null ? null : this.datastore.get(id).clone();
    }

    public void updateTradeAccount(TradeAccount tradeAccount) {
        if (tradeAccount != null && datastore.containsKey(tradeAccount.getId())) {
            datastore.put(tradeAccount.getId(), tradeAccount.clone());
        } else {
            throw new IllegalArgumentException("Trade account does not exist or is null");
        }
    }

    public void deleteTradeAccount(String id) {
        if (id != null && datastore.containsKey(id)) {
            datastore.remove(id);
        } else {
            throw new IllegalArgumentException("Trade account does not exist or id is null");
        }
    }

}
