package org.joao.com.dao;

import org.joao.com.model.DocumentType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentTypeDAO extends DAO<DocumentType> {
    public DocumentTypeDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "readAllProcedure", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, DocumentType documentType) throws SQLException {
        sp.setString(1, documentType.getNameDocumentType());
        if (documentType.getIdDocumentType() == 0) return;
        sp.setInt(2, documentType.getIdDocumentType());
    }

    @Override
    public DocumentType resultSetToObject(ResultSet resultSet) throws SQLException {
        int idDocumentType = resultSet.getInt(1);
        String nameDocumentType = resultSet.getString(2);

        return new DocumentType(idDocumentType, nameDocumentType);
    }
}
