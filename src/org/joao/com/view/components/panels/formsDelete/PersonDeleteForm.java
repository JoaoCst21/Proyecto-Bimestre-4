package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.PersonDAO;
import org.joao.com.model.Person;
import org.joao.com.view.components.FormDelete;

public class PersonDeleteForm extends FormDelete<Person> {
    public PersonDeleteForm() {
        super(new String[]{"Nombre", "Apellido", "Dirección", "Telefono", "Usuario", "Password", "Fecha", "Sexo", "Nacionalidad", "Numero de Documento", "ID Tipo de Documento", "ID Compañia Telefonica"}, "Eliminar Persona");
    }

    @Override
    public void deleteInDatabase(int id) {
        new PersonDAO().delete(id);
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
