package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.ProveedorDAO;
import org.joao.com.model.Proveedor;
import org.joao.com.view.components.FormUpdate;

public class ProviderUpdateForm extends FormUpdate<Proveedor> {
    public ProviderUpdateForm() {
        super(new String[]{"Nombre", "Tipo de Servicio", "Descripción", "Cuenta Asociada"}, "Modificar Proveedor");
    }

    @Override
    public Proveedor stringArrToObj() {
        int id = Integer.parseInt(buscarInput.getText());
        String name = inputs.get("Nombre").getText();
        String typeService = inputs.get("Tipo de Servicio").getText();
        String description = inputs.get("Descripción").getText();
        int idAccount = Integer.parseInt(inputs.get("Cuenta Asociada").getText());

        return new Proveedor(id, name, typeService, description, idAccount);

    }

    @Override
    public void updateInDatabase() {
        new ProveedorDAO().update(stringArrToObj());
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
