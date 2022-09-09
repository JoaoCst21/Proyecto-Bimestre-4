package org.joao.com.model;

public class DocumentType {
    // Attributes
    private int idDocumentType;
    private String nameDocumentType;

    // Constructor
    public DocumentType(int idDocumentType, String nameDocumentType) {
        this.idDocumentType = idDocumentType;
        this.nameDocumentType = nameDocumentType;
    }

    // Getters
    public int getIdDocumentType() {
        return idDocumentType;
    }

    public String getNameDocumentType() {
        return nameDocumentType;
    }

    // Setters
    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public void setNameDocumentType(String nameDocumentType) {
        this.nameDocumentType = nameDocumentType;
    }
}
