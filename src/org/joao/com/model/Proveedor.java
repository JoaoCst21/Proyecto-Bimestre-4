package org.joao.com.model;

public class Proveedor {
    // Attributes
    private int idProveedor;
    private String nameProveedor;
    private String typeService;
    private String description;
    private int _idAccount;

    // Constructor
    public Proveedor(int idProveedor, String nameProveedor, String typeService, String description, int _idAccount) {
        this.idProveedor = idProveedor;
        this.nameProveedor = nameProveedor;
        this.typeService = typeService;
        this.description = description;
        this._idAccount = _idAccount;
    }

    // Getters
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNameProveedor() {
        return nameProveedor;
    }

    public String getTypeService() {
        return typeService;
    }

    public String getDescription() {
        return description;
    }

    public int get_idAccount() {
        return _idAccount;
    }

    // Setters
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNameProveedor(String nameProveedor) {
        this.nameProveedor = nameProveedor;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void set_idAccount(int _idAccount) {
        this._idAccount = _idAccount;
    }
}
