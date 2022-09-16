package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.DocumentTypeDAO;
import org.joao.com.model.DocumentType;
import org.joao.com.view.components.FormUpdate;

public class DocumentTypeUpdateForm extends FormUpdate<DocumentType> {
    public DocumentTypeUpdateForm() {
        super(new String[]{"Tipo de Documento"}, "Modificar un Tipo de Documento");
    }

    @Override
    public DocumentType stringArrToObj() {
        return new DocumentType(Integer.parseInt(buscarInput.getText()), inputs.get("Tipo de Documento").getText());
    }

    @Override
    public void updateInDatabase() {
        new DocumentTypeDAO().update(stringArrToObj());
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
