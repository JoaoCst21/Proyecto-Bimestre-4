package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.PhoneCompanyDAO;
import org.joao.com.model.PhoneCompany;
import org.joao.com.view.components.FormUpdate;

public class PhoneCompanyUpdateForm extends FormUpdate<PhoneCompany> {
    public PhoneCompanyUpdateForm() {
        super(new String[]{"Compañia Telefonica"}, "Modificar una Compañia\r\nTelefonica");
    }

    @Override
    public PhoneCompany stringArrToObj() {
        return new PhoneCompany(Integer.parseInt(buscarInput.getText()), inputs.get("Compañia Telefonica").getText());
    }

    @Override
    public void updateInDatabase() {
        new PhoneCompanyDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(PhoneCompany phoneCompany) {
        String nameCompany = phoneCompany.getNameCompany();

        return new String[]{nameCompany};
    }

    @Override
    protected PhoneCompany searchInDB(int id) {
        return new PhoneCompanyDAO().search(id);
    }
}
