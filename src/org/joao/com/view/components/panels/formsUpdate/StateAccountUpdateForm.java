package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.StateAccountDAO;
import org.joao.com.model.StateAccount;
import org.joao.com.view.components.FormUpdate;

public class StateAccountUpdateForm extends FormUpdate<StateAccount> {
    public StateAccountUpdateForm() {
        super(new String[]{"Estado de Cuenta"}, "Modificar un Estado de Cuenta");
    }

    @Override
    public StateAccount stringArrToObj() {
        return new StateAccount(Integer.parseInt(buscarInput.getText()), inputs.get("Estado de Cuenta").getText());
    }

    @Override
    public void updateInDatabase() {
        new StateAccountDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(StateAccount stateAccount) {
        String stateAccountName = stateAccount.getStateAccount();

        return new String[]{stateAccountName};
    }

    @Override
    protected StateAccount searchInDB(int id) {
        return new StateAccountDAO().search(id);
    }
}
