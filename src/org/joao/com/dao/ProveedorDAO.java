package org.joao.com.dao;

import org.joao.com.model.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorDAO extends DAO<Proveedor> {
    public ProveedorDAO() {
        super("enterProvider_sp(?,?,?,?)", "updateProvider_sp(?,?,?,?,?)", "searchProcedure", "getAllProviders_sp()", "deleteProvider_sp(?)");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Proveedor proveedor) throws SQLException {
        sp.setString(1, proveedor.getNameProveedor());
        sp.setString(2, proveedor.getTypeService());
        sp.setString(3, proveedor.getDescription());
        sp.setInt(4, proveedor.get_idAccount());
        if (proveedor.getIdProveedor() == 0) return;
        sp.setInt(5, proveedor.getIdProveedor());
    }

    @Override
    public Proveedor resultSetToObject(ResultSet resultSet) throws SQLException {
        int idProveedor = resultSet.getInt(1);
        String nameProveedor = resultSet.getString(2);
        String typeService = resultSet.getString(3);
        String description = resultSet.getString(4);
        int _idAccount = resultSet.getInt(5);

        return new Proveedor(idProveedor, nameProveedor, typeService, description, _idAccount);
    }
}
