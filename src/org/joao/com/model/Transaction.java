package org.joao.com.model;

import java.util.Date;

public class Transaction {
    // Attributes
    private int idTransaction;
    private int _idAccountSender;
    private int _idAccountReceiver;
    private int _idProveedor;
    private String paymentIdentifier;
    private String description;
    private Double amount;
    private Date dateTransaction;

    // Constructor
    public Transaction(int idTransaction, int _idAccountReceiver, int _idAccountSender, int _idProveedor, String paymentIdentifier, String description, Double amount, Date dateTransaction) {
        this.idTransaction = idTransaction;
        this._idAccountReceiver = _idAccountReceiver;
        this._idAccountSender = _idAccountSender;
        this._idProveedor = _idProveedor;
        this.paymentIdentifier = paymentIdentifier;
        this.description = description;
        this.amount = amount;
        this.dateTransaction = dateTransaction;
    }

    // Getters
    public int getIdTransaction() {
        return idTransaction;
    }

    public int get_idAccountReceiver() {
        return _idAccountReceiver;
    }

    public int get_idAccountSender() {
        return _idAccountSender;
    }

    public int get_idProveedor() {
        return _idProveedor;
    }

    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    // Setters
    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void set_idAccountReceiver(int _idAccountReceiver) {
        this._idAccountReceiver = _idAccountReceiver;
    }

    public void set_idAccountSender(int _idAccountSender) {
        this._idAccountSender = _idAccountSender;
    }

    public void set_idProveedor(int _idProveedor) {
        this._idProveedor = _idProveedor;
    }

    public void setPaymentIdentifier(String paymentIdentifier) {
        this.paymentIdentifier = paymentIdentifier;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", _idAccountReceiver=" + _idAccountReceiver +
                ", _idAccountSender=" + _idAccountSender +
                ", _idProveedor=" + _idProveedor +
                ", paymentIdentifier='" + paymentIdentifier + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", dateTransaction=" + dateTransaction +
                '}';
    }
}
