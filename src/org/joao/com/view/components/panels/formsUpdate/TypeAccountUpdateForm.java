package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.TypeAccountDAO;
import org.joao.com.model.TypeAccount;
import org.joao.com.view.components.FormUpdate;

public class TypeAccountUpdateForm extends FormUpdate<TypeAccount> {
    public TypeAccountUpdateForm() {
        super(new String[]{"Tipo de Cuenta"}, "Modificar un Tipo De Cuenta");
    }

    @Override
    public TypeAccount stringArrToObj() {
        return new TypeAccount(Integer.parseInt(buscarInput.getText()), inputs.get("Tipo de Cuenta").getText());
    }

    @Override
    public void updateInDatabase() {
        new TypeAccountDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(TypeAccount typeAccount) {
        String idStateAccount = String.valueOf(typeAccount.getIdStateAccount());
        String nameStateAccount = typeAccount.getNameStateAccount();

        return new String[]{idStateAccount, nameStateAccount};
    }

    @Override
    protected TypeAccount searchInDB(int id) {
        return new TypeAccountDAO().search(id);
    }
}
