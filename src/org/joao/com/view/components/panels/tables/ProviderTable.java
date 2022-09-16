package org.joao.com.view.components.panels.tables;


import org.joao.com.model.Proveedor;
import org.joao.com.view.components.PanelTable;

public class ProviderTable extends PanelTable<Proveedor> {

    public ProviderTable(Proveedor[] data) {
        super(data, new String[]{"ID Proveedor", "Nombre", "Tipo de Servicio", "Descripcion", "Numero de Cuenta"}, "Proveedor");
    }

    @Override
    public String[] dataToStringArr(Proveedor provider) {
        String idProveedor = String.valueOf(provider.getIdProveedor());
        String nameProveedor = provider.getNameProveedor();
        String typeService = provider.getTypeService();
        String description = provider.getDescription();
        String _idAccount = String.valueOf(provider.get_idAccount());
        return new String[]{idProveedor, nameProveedor, typeService, description, _idAccount};
    }
}
