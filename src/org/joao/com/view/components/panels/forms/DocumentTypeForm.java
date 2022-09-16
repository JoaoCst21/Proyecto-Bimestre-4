package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.DocumentTypeDAO;
import org.joao.com.model.DocumentType;
import org.joao.com.view.components.Form;

public class DocumentTypeForm extends Form<DocumentType> {
    public DocumentTypeForm() {
        super(new String[]{"Tipo de Documento"}, "Crear un Tipo de Documento");
    }

    @Override
    public DocumentType stringArrToObj() {
        return new DocumentType(0, inputs.get("Tipo de Documento").getText());
    }

    @Override
    public void saveInDatabase() {
        new DocumentTypeDAO().save(stringArrToObj());
    }

}
