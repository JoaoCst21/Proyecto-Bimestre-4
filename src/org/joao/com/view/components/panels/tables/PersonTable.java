package org.joao.com.view.components.panels.tables;

import org.joao.com.model.Person;
import org.joao.com.view.components.PanelTable;

public class PersonTable extends PanelTable<Person> {

    public PersonTable(Person[] data) {
        super(data, new String[]{"ID persona", "Nombre", "Apellido", "Dirección", "Telefono", "Usuario", "Contraseña", "Usuario desde", "Sexo", "nacionalidad", "Numero de Documento", "Tipo de documento", "Compañia Telefonica"}, "Personas");
    }

    @Override
    public String[] dataToStringArr(Person person) {
        String idPerson = String.valueOf(person.getIdPerson());
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

        return new String[]{idPerson, personName, lastName, direction, phone, userName, password, dateCreation, gender, nacionality, numberDocumentType, _idDocumentType, _idPhoneCompany};
    }
}
