package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.PersonDAO;
import org.joao.com.model.Person;
import org.joao.com.view.components.FormUpdate;

import java.sql.Date;

public class PersonUpdateForm extends FormUpdate<Person> {
    public PersonUpdateForm() {
        super(new String[]{"Nombre", "Apellido", "Dirección", "Telefono", "Usuario", "Password", "Fecha", "Sexo", "Nacionalidad", "Numero de Documento", "ID Tipo de Documento", "ID Compañia Telefonica"}, "Modificar Persona");

    }

    @Override
    public Person stringArrToObj() {
        int id = Integer.parseInt(buscarInput.getText());
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

        return new Person(id, name, lastName, nacionality, documentNumber, address, user, password, gender, date, phoneNumber, idTypeDocument, idPhoneCompany);
    }

    @Override
    public void updateInDatabase() {
        new PersonDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(Person person) {
        String personName = person.getPersonName();
        String lastName = person.getLastName();
        String direction = person.getDirection();
        String phone = String.valueOf(person.getPhone());
        String userName = person.getUserName();
        String password = person.getPassword();
        String dateCreation = String.valueOf(person.getDateCreation());
        String gender = person.getGender();
        String nacionality = person.getNacionality();
        String numberDocumentType = person.getNumberDocumentType();
        String _idDocumentType = String.valueOf(person.get_idDocumentType());
        String _idPhoneCompany = String.valueOf(person.get_idPhoneCompany());

        return new String[]{personName, lastName, direction, phone, userName, password, dateCreation, gender, nacionality, numberDocumentType, _idDocumentType, _idPhoneCompany};
    }

    @Override
    protected Person searchInDB(int id) {
        return new PersonDAO().search(id);
    }
}
