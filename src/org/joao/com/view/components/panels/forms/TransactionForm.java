package org.joao.com.view.components.panels.forms;

import org.joao.com.view.components.Form;

public class TransactionForm extends Form {
    public TransactionForm() {
        super(new String[]{"depositario", "depositante", "proveedor", "Identificacion de Pago", "Descripcion", "Monto"}, "Crear Transaccion");
    }
}
