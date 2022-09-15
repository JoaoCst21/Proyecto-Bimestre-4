package org.joao.com.view.components.panels.forms;

import org.joao.com.view.components.Form;

public class PersonForm extends Form {

    public PersonForm() {
        super(new String[]{"Nombre", "Apellido", "Dirección", "Telefono", "Usuario", "Password", "Fecha", "Sexo", "Nacionalidad", "Numero de Documento", "ID Tipo de Documento", "ID Compañia Telefonica"}, "Crear Persona");
    }
}
