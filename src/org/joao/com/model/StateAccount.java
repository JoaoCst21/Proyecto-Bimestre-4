package org.joao.com.model;

public class StateAccount {
    // Attributes
    private int idStateAccount;
    private String stateAccount;

    // Constructor
    public StateAccount(int idStateAccount, String stateAccount) {
        this.idStateAccount = idStateAccount;
        this.stateAccount = stateAccount;
    }

    // Getters
    public int getIdStateAccount() {
        return idStateAccount;
    }

    public String getStateAccount() {
        return stateAccount;
    }

    // Setters
    public void setIdStateAccount(int idStateAccount) {
        this.idStateAccount = idStateAccount;
    }

    public void setStateAccount(String stateAccount) {
        this.stateAccount = stateAccount;
    }
}
