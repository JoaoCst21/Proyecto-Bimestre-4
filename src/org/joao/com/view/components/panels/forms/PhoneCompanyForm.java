package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.PhoneCompanyDAO;
import org.joao.com.model.PhoneCompany;
import org.joao.com.view.components.Form;

public class PhoneCompanyForm extends Form<PhoneCompany> {
    public PhoneCompanyForm() {
        super(new String[]{"Compañia Telefonica"}, "Crear una Compañia Telefonica");
    }

    @Override
    public PhoneCompany stringArrToObj() {
        return new PhoneCompany(0, inputs.get("Compañia Telefonica").getText());
    }

    @Override
    public void saveInDatabase() {
        new PhoneCompanyDAO().save(stringArrToObj());
    }

}
