package org.joao.com.model;

public class Currency {
    // Attributes
    private int idCurrency;
    private String currencyName;

    // Constructor
    public Currency(int idCurrency, String currencyName) {
        this.idCurrency = idCurrency;
        this.currencyName = currencyName;
    }

    // Getters
    public int getIdCurrency() {
        return idCurrency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    // Setters
    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
