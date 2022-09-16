package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.DocumentTypeDAO;
import org.joao.com.model.DocumentType;
import org.joao.com.view.components.FormDelete;

public class DocumentTypeDeleteForm extends FormDelete<DocumentType> {
    public DocumentTypeDeleteForm() {
        super(new String[]{"Tipo de Documento"}, "Eliminar un Tipo de Documentos");
    }

    @Override
    public void deleteInDatabase(int id) {
        new DocumentTypeDAO().delete(id);
    }

    @Override
    protected String[] dataToStringArr(DocumentType documentType) {
        String nameDocumentType = documentType.getNameDocumentType();

        return new String[]{nameDocumentType};
    }

    @Override
    protected DocumentType searchInDB(int id) {
        return new DocumentTypeDAO().search(id);
    }
}
