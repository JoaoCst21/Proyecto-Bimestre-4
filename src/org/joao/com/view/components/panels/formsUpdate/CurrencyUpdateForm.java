package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.CurrencyDAO;
import org.joao.com.model.Currency;
import org.joao.com.view.components.FormUpdate;

public class CurrencyUpdateForm extends FormUpdate<Currency> {
    public CurrencyUpdateForm() {
        super(new String[]{"Nombre"}, "Modificar Moneda");
    }

    @Override
    public Currency stringArrToObj() {
        return new Currency(Integer.parseInt(buscarInput.getText()), inputs.get("Nombre").getText());
    }

    @Override
    public void updateInDatabase() {
        new CurrencyDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(Currency currency) {
        String currencyName = currency.getCurrencyName();
        return new String[]{currencyName};
    }

    @Override
    protected Currency searchInDB(int id) {
        return new CurrencyDAO().search(id);
    }
}
