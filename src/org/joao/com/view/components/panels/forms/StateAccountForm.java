package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.StateAccountDAO;
import org.joao.com.model.StateAccount;
import org.joao.com.view.components.Form;

public class StateAccountForm extends Form<StateAccount> {
    public StateAccountForm() {
        super(new String[]{"Estado de Cuenta"}, "Crear un Estado de Cuenta");
    }

    @Override
    public StateAccount stringArrToObj() {
        return new StateAccount(0, inputs.get("Estado de Cuenta").getText());
    }

    @Override
    public void saveInDatabase() {
        new StateAccountDAO().save(stringArrToObj());
    }

}
