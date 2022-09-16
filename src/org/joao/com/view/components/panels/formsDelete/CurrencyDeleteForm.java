package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.CurrencyDAO;
import org.joao.com.model.Currency;
import org.joao.com.view.components.FormDelete;

public class CurrencyDeleteForm extends FormDelete<Currency> {
    public CurrencyDeleteForm() {
        super(new String[]{"Nombre"}, "Eliminar Moneda");
    }

    @Override
    public void deleteInDatabase(int id) {
        new CurrencyDAO().delete(id);
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
