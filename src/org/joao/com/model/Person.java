package org.joao.com.model;

public class Person {
    // Attributes
    private int idPerson;
    private String personName;
    private String lastName;
    private String nacionality;
    private String numberDocumentType;
    private String direction;
    private String userName;
    private String password;
    private String gender;
    private String dateCreation;
    private int phone;

    private int _idDocumentType;
    private int _idPhoneCompany;

    // Constructor
    public Person(int idPerson, String personName, String lastName, String nacionality, String numberDocumentType, String direction, String userName, String password, String gender, String dateCreation, int phone, int _idDocumentType, int _idPhoneCompany) {
        this.idPerson = idPerson;
        this.personName = personName;
        this.lastName = lastName;
        this.nacionality = nacionality;
        this.numberDocumentType = numberDocumentType;
        this.direction = direction;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.dateCreation = dateCreation;
        this.phone = phone;
        this._idDocumentType = _idDocumentType;
        this._idPhoneCompany = _idPhoneCompany;
    }

    // Getters
    public int getIdPerson() {
        return idPerson;
    }

    public String getPersonName() {
        return personName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNacionality() {
        return nacionality;
    }

    public String getNumberDocumentType() {
        return numberDocumentType;
    }

    public String getDirection() {
        return direction;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public int getPhone() {
        return phone;
    }

    public int get_idDocumentType() {
        return _idDocumentType;
    }

    public int get_idPhoneCompany() {
        return _idPhoneCompany;
    }

    // Setters
    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public void setNumberDocumentType(String numberDocumentType) {
        this.numberDocumentType = numberDocumentType;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void set_idDocumentType(int _idDocumentType) {
        this._idDocumentType = _idDocumentType;
    }

    public void set_idPhoneCompany(int _idPhoneCompany) {
        this._idPhoneCompany = _idPhoneCompany;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", personName='" + personName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nacionality='" + nacionality + '\'' +
                ", numberDocumentType='" + numberDocumentType + '\'' +
                ", direction='" + direction + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", phone=" + phone +
                ", _idDocumentType=" + _idDocumentType +
                ", _idPhoneCompany=" + _idPhoneCompany +
                '}';
    }
}

