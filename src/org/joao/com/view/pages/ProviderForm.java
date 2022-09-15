package org.joao.com.view.pages;

import org.joao.com.view.components.Form;

public class ProviderForm extends Form {
    public ProviderForm() {
        super(new String[]{"Nombre", "Tipo de Servicio", "Descripción", "Cuenta Asociada"}, "Crear Proveedor");
    }
}
