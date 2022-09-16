package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.PersonDAO;
import org.joao.com.model.Person;
import org.joao.com.view.components.Form;

import java.sql.Date;

public class PersonForm extends Form<Person> {

    public PersonForm() {
        super(new String[]{"Nombre", "Apellido", "Dirección", "Telefono", "Usuario", "Password", "Fecha", "Sexo", "Nacionalidad", "Numero de Documento", "ID Tipo de Documento", "ID Compañia Telefonica"}, "Crear Persona");
    }

    @Override
    public Person stringArrToObj() {
        String name = inputs.get("Nombre").getText();
        String lastName = inputs.get("Apellido").getText();
        String address = inputs.get("Dirección").getText();
        int phoneNumber = Integer.parseInt(inputs.get("Telefono").getText());
        String user = inputs.get("Usuario").getText();
        String password = inputs.get("Password").getText();
        Date date = Date.valueOf(inputs.get("Fecha").getText());
        String gender = inputs.get("Sexo").getText();
        String nacionality = inputs.get("Nacionalidad").getText();
        String documentNumber = inputs.get("Numero de Documento").getText();
        int idTypeDocument = Integer.parseInt(inputs.get("ID Tipo de Documento").getText());
        int idPhoneCompany = Integer.parseInt(inputs.get("ID Compañia Telefonica").getText());

        return new Person(0, name, lastName, nacionality, documentNumber, address, user, password, gender, date, phoneNumber, idTypeDocument, idPhoneCompany);
    }

    @Override
    public void saveInDatabase() {
        new PersonDAO().save(stringArrToObj());
    }
}
