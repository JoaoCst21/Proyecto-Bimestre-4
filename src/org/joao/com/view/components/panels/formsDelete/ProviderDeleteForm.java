package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.ProveedorDAO;
import org.joao.com.model.Proveedor;
import org.joao.com.view.components.FormDelete;

public class ProviderDeleteForm extends FormDelete<Proveedor> {
    public ProviderDeleteForm() {
        super(new String[]{"Nombre", "Tipo de Servicio", "Descripción", "Cuenta Asociada"}, "Eliminar Proveedor");
    }

    @Override
    public void deleteInDatabase(int id) {
        new ProveedorDAO().delete(id);
    }

    @Override
    protected String[] dataToStringArr(Proveedor provider) {
        String nameProveedor = provider.getNameProveedor();
        String typeService = provider.getTypeService();
        String description = provider.getDescription();
        String _idAccount = String.valueOf(provider.get_idAccount());
        return new String[]{nameProveedor, typeService, description, _idAccount};
    }

    @Override
    protected Proveedor searchInDB(int id) {
        return new ProveedorDAO().search(id);
    }
}
