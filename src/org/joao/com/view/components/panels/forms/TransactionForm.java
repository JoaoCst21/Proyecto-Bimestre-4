package org.joao.com.view.components.panels.forms;

import org.joao.com.dao.TransactionDAO;
import org.joao.com.model.Transaction;
import org.joao.com.view.components.Form;

import java.sql.Date;

public class TransactionForm extends Form<Transaction> {
    public TransactionForm() {
        super(new String[]{"Depositario", "Depositante", "Proveedor", "Identificacion de Pago", "Descripcion", "Monto", "Fecha"}, "Crear Transacción");
    }

    @Override
    public Transaction stringArrToObj() {
        int depositario = Integer.parseInt(inputs.get("Depositario").getText());
        int depositante = Integer.parseInt(inputs.get("Depositante").getText());
        int provider = Integer.parseInt(inputs.get("Proveedor").getText());
        String paymentIdentifier = inputs.get("Identificacion de Pago").getText();
        String description = inputs.get("Descripcion").getText();
        Double amount = Double.valueOf(inputs.get("Monto").getText());
        Date date = Date.valueOf(inputs.get("Fecha").getText());

        return new Transaction(0, depositario, depositante, provider, paymentIdentifier, description, amount, date);
    }

    @Override
    public void saveInDatabase() {
        new TransactionDAO().save(stringArrToObj());
    }
}
