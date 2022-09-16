package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.TransactionDAO;
import org.joao.com.model.Transaction;
import org.joao.com.view.components.FormDelete;

public class TransactionDeleteForm extends FormDelete<Transaction> {
    public TransactionDeleteForm() {
        super(new String[]{"Depositario", "Depositante", "Proveedor", "Identificacion de Pago", "Descripcion", "Monto", "Fecha"}, "Eliminar Transacción");
    }

    @Override
    public void deleteInDatabase(int id) {
        new TransactionDAO().delete(id);
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
