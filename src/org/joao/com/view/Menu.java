package org.joao.com.view;

public class Menu extends View {

    public void showMenu() {
        System.out.println("Bienvenido a nuestra pequeña demo");
        String constantSentence = "una Compañia de Telefono";
        showOptions(new String[]{"crear " + constantSentence, "modificar " + constantSentence, "buscar " +
                constantSentence, "listar todas las Compañias", "eliminar " + constantSentence});
    }
}
