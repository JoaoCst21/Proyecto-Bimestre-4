package org.joao.com.view.components.panels.tables;

import org.joao.com.model.Currency;
import org.joao.com.view.components.PanelTable;

public class CurrencyTable extends PanelTable<Currency> {

    public CurrencyTable(Currency[] data) {
        super(data, new String[]{"ID", "Moneda"}, "Monedas");
    }

    @Override
    protected String[] dataToStringArr(Currency currency) {
        String idCurrency = String.valueOf(currency.getIdCurrency());
        String currencyName = currency.getCurrencyName();
        return new String[]{idCurrency, currencyName};
    }
}
