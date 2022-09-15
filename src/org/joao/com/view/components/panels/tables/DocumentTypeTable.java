package org.joao.com.view.components.panels.tables;

import org.joao.com.model.DocumentType;
import org.joao.com.view.components.PanelTable;

public class DocumentTypeTable extends PanelTable<DocumentType> {
    public DocumentTypeTable(DocumentType[] data) {
        super(data, new String[]{"ID", "Tipo de Documento"}, "Tipos de Documentos");
    }

    @Override
    protected String[] dataToStringArr(DocumentType documentType) {
        String idDocumentType = String.valueOf(documentType.getIdDocumentType());
        String nameDocumentType = documentType.getNameDocumentType();

        return new String[]{idDocumentType, nameDocumentType};
    }
}
