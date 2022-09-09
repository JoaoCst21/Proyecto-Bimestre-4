package org.joao.com.model;

public class PhoneCompany {
    // Attributes
    private int idPhoneCompany;
    private String nameCompany;

    // Constructor
    public PhoneCompany(int idPhoneCompany, String nameCompany) {
        this.idPhoneCompany = idPhoneCompany;
        this.nameCompany = nameCompany;
    }

    // Getters
    public int getIdPhoneCompany() {
        return idPhoneCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    // Setters
    public void setIdPhoneCompany(int idPhoneCompany) {
        this.idPhoneCompany = idPhoneCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }
}
