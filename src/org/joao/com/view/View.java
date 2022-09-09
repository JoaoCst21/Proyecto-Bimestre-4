package org.joao.com.view;

import java.util.ArrayList;

public class View {
    protected void showOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            String option = options[i];
            System.out.println("Presione " + (i + 1) + " para " + option);
        }
    }

    public <T extends Object> void showObjects(ArrayList<T> objects) {
        for (T object : objects)
            System.out.println(object.toString());
    }
}
