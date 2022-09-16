package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.TypeAccountDAO;
import org.joao.com.model.TypeAccount;
import org.joao.com.view.components.Form;

public class TypeAccountForm extends Form<TypeAccount> {
    public TypeAccountForm() {
        super(new String[]{"Tipo de Cuenta"}, "Crear un Tipo De Cuenta");
    }

    @Override
    public TypeAccount stringArrToObj() {
        return new TypeAccount(0, inputs.get("Tipo de Cuenta").getText());
    }

    @Override
    public void saveInDatabase() {
        new TypeAccountDAO().save(stringArrToObj());
    }


}
