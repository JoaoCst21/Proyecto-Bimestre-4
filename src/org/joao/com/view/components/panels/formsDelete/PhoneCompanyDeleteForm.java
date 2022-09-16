package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.PhoneCompanyDAO;
import org.joao.com.model.PhoneCompany;
import org.joao.com.view.components.FormDelete;

public class PhoneCompanyDeleteForm extends FormDelete<PhoneCompany> {
    public PhoneCompanyDeleteForm() {
        super(new String[]{"Compañia Telefonica"}, "Eliminar una Compañia Telefonica");
    }

    @Override
    public void deleteInDatabase(int id) {
        new PhoneCompanyDAO().delete(id);
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
