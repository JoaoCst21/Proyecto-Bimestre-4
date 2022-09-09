package org.joao.com.model;

public class Account {
    // Attributes
    private int idAccount;
    private Double balance;
    private int _propietaryAccountId;
    private int _currency;
    private int _typeAccount;
    private int _stateAccount;

    // Constructor
    public Account(int idAccount, Double balance, int _propietaryAccountId, int _currency, int _typeAccount, int _stateAccount) {
        this.idAccount = idAccount;
        this.balance = balance;
        this._propietaryAccountId = _propietaryAccountId;
        this._currency = _currency;
        this._typeAccount = _typeAccount;
        this._stateAccount = _stateAccount;
    }


    // Getters
    public int getIdAccount() {
        return idAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public int get_propietaryAccountId() {
        return _propietaryAccountId;
    }

    public int get_currency() {
        return _currency;
    }

    public int get_typeAccount() {
        return _typeAccount;
    }

    public int get_stateAccount() {
        return _stateAccount;
    }

    // Setters
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void set_propietaryAccountId(int _propietaryAccountId) {
        this._propietaryAccountId = _propietaryAccountId;
    }

    public void set_currency(int _currency) {
        this._currency = _currency;
    }

    public void set_typeAccount(int _typeAccount) {
        this._typeAccount = _typeAccount;
    }

    public void set_stateAccount(int _stateAccount) {
        this._stateAccount = _stateAccount;
    }
}
