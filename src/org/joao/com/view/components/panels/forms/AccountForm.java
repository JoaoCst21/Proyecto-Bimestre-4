package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.AccountDAO;
import org.joao.com.model.Account;
import org.joao.com.view.components.Form;

public class AccountForm extends Form<Account> {
    public AccountForm() {
        super(new String[]{"Balance", "id Propietario", "ID Moneda", "ID Tipo de Cuenta", "ID Estado de Cuenta"}, "Crear Cuenta");
    }

    @Override
    public Account stringArrToObj() {
        Double balance = Double.valueOf(inputs.get("Balance").getText());
        int idPropietary = Integer.parseInt(inputs.get("id Propietario").getText());
        int idMoneda = Integer.parseInt(inputs.get("ID Moneda").getText());
        int idTypeAccount = Integer.parseInt(inputs.get("ID Tipo de Cuenta").getText());
        int idStateAccount = Integer.parseInt(inputs.get("ID Estado de Cuenta").getText());

        return new Account(0, balance, idPropietary, idMoneda, idTypeAccount, idStateAccount);
    }

    @Override
    public void saveInDatabase() {
        new AccountDAO().save(stringArrToObj());
    }

}
