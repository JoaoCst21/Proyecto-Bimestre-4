package org.joao.com.view.components.panels.tables;

import org.joao.com.model.Transaction;
import org.joao.com.view.components.PanelTable;

public class TransactionTable extends PanelTable<Transaction> {

    public TransactionTable(Transaction[] data) {
        super(data, new String[]{"ID Transacción", "Enviador", "recibidor", "Provider", "Identificador de Pago", "Descripcion", "monto", "Fecha"}, "Transacciones");
    }

    @Override
    public String[] dataToStringArr(Transaction transaction) {
        String id = String.valueOf(transaction.getIdTransaction());
        String sender = String.valueOf(transaction.get_idAccountSender());
        String receiver = String.valueOf(transaction.get_idAccountReceiver());
        String provider = String.valueOf(transaction.get_idProveedor());
        String paymentIdentifier = transaction.getPaymentIdentifier();
        String description = transaction.getDescription();
        String amount = String.valueOf(transaction.getAmount());
        String dateTransaction = String.valueOf(transaction.getDateTransaction());
        return new String[]{id, sender, receiver, provider, paymentIdentifier, description, amount, dateTransaction};
    }
}
