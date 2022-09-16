package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.ProveedorDAO;
import org.joao.com.model.Proveedor;
import org.joao.com.view.components.Form;

public class ProviderForm extends Form<Proveedor> {
    public ProviderForm() {
        super(new String[]{"Nombre", "Tipo de Servicio", "Descripción", "Cuenta Asociada"}, "Crear Proveedor");
    }

    @Override
    public Proveedor stringArrToObj() {
        String name = inputs.get("Nombre").getText();
        String typeService = inputs.get("Tipo de Servicio").getText();
        String description = inputs.get("Descripción").getText();
        int idAccount = Integer.parseInt(inputs.get("Cuenta Asociada").getText());

        return new Proveedor(0, name, typeService, description, idAccount);
    }

    @Override
    public void saveInDatabase() {
        new ProveedorDAO().save(stringArrToObj());
    }

}
