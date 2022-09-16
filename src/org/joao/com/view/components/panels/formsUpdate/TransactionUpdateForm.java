package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.TransactionDAO;
import org.joao.com.model.Transaction;
import org.joao.com.view.components.FormUpdate;

import java.sql.Date;

public class TransactionUpdateForm extends FormUpdate<Transaction> {
    public TransactionUpdateForm() {
        super(new String[]{"Depositario", "Depositante", "Proveedor", "Identificacion de Pago", "Descripcion", "Monto", "Fecha"}, "Modificar Transacción");

    }

    @Override
    public Transaction stringArrToObj() {
        int id = Integer.parseInt(buscarInput.getText());
        int depositario = Integer.parseInt(inputs.get("Depositario").getText());
        int depositante = Integer.parseInt(inputs.get("Depositante").getText());
        int provider = Integer.parseInt(inputs.get("Proveedor").getText());
        String paymentIdentifier = inputs.get("Identificacion de Pago").getText();
        String description = inputs.get("Descripcion").getText();
        Double amount = Double.valueOf(inputs.get("Monto").getText());
        Date date = Date.valueOf(inputs.get("Fecha").getText());

        return new Transaction(id, depositario, depositante, provider, paymentIdentifier, description, amount, date);

    }

    @Override
    public void updateInDatabase() {
        new TransactionDAO().update(stringArrToObj());
    }

    @Override
    protected String[] dataToStringArr(Transaction transaction) {
        String sender = String.valueOf(transaction.get_idAccountSender());
        String receiver = String.valueOf(transaction.get_idAccountReceiver());
        String provider = String.valueOf(transaction.get_idProveedor());
        String paymentIdentifier = transaction.getPaymentIdentifier();
        String description = transaction.getDescription();
        String amount = String.valueOf(transaction.getAmount());
        String dateTransaction = String.valueOf(transaction.getDateTransaction());
        return new String[]{receiver, sender, provider, paymentIdentifier, description, amount, dateTransaction};
    }

    @Override
    protected Transaction searchInDB(int id) {
        return new TransactionDAO().search(id);
    }
}
