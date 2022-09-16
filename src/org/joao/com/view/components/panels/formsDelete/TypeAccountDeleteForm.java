package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.TypeAccountDAO;
import org.joao.com.model.TypeAccount;
import org.joao.com.view.components.FormDelete;

public class TypeAccountDeleteForm extends FormDelete<TypeAccount> {
    public TypeAccountDeleteForm() {
        super(new String[]{"Tipo de Cuenta"}, "Eliminar un Tipo De Cuenta");
    }

    @Override
    public void deleteInDatabase(int id) {
        new TypeAccountDAO().delete(id);
    }

    @Override
    protected String[] dataToStringArr(TypeAccount typeAccount) {
        String nameStateAccount = typeAccount.getNameStateAccount();
        return new String[]{nameStateAccount};
    }

    @Override
    protected TypeAccount searchInDB(int id) {
        return new TypeAccountDAO().search(id);
    }
}
