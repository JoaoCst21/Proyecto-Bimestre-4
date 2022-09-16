package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.CurrencyDAO;
import org.joao.com.model.Currency;
import org.joao.com.view.components.Form;

public class CurrencyForm extends Form<Currency> {
    public CurrencyForm() {
        super(new String[]{"Nombre"}, "Crear Moneda");
    }

    @Override
    public Currency stringArrToObj() {
        return new Currency(0, inputs.get("Nombre").getText());
    }

    @Override
    public void saveInDatabase() {
        new CurrencyDAO().save(stringArrToObj());
    }

}
