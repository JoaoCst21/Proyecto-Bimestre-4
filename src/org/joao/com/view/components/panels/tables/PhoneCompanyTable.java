package org.joao.com.view.components.panels.tables;

import org.joao.com.model.PhoneCompany;
import org.joao.com.view.components.PanelTable;

public class PhoneCompanyTable extends PanelTable<PhoneCompany> {
    public PhoneCompanyTable(PhoneCompany[] data) {
        super(data, new String[]{"ID", "Nombre Compañia"}, "Compañias de Telefonia");
    }

    @Override
    public String[] dataToStringArr(PhoneCompany phoneCompany) {
        String idPhoneCompany = String.valueOf(phoneCompany.getIdPhoneCompany());
        String nameCompany = phoneCompany.getNameCompany();

        return new String[]{idPhoneCompany, nameCompany};
    }
}
