package org.joao.com.dao;

import java.util.ArrayList;

public interface CRUD<Class> {
    public void save(Class object);

    public void update(Class object);

    public Class search(int idObject);

    public ArrayList<Class> readAll();

    public void delete(int idObject);
}
