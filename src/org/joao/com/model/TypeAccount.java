package org.joao.com.model;

public class TypeAccount {
    // Attributes
    private int idStateAccount;
    private String nameStateAccount;

    // Constructor
    public TypeAccount(int idStateAccount, String nameStateAccount) {
        this.idStateAccount = idStateAccount;
        this.nameStateAccount = nameStateAccount;
    }

    // Getters
    public int getIdStateAccount() {
        return idStateAccount;
    }

    public String getNameStateAccount() {
        return nameStateAccount;
    }

    // Setters
    public void setIdStateAccount(int idStateAccount) {
        this.idStateAccount = idStateAccount;
    }

    public void setNameStateAccount(String nameStateAccount) {
        this.nameStateAccount = nameStateAccount;
    }
}
