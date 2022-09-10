package org.joao.com.view;

import java.util.Scanner;

public class Menu extends View {

    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Bienvenido a nuestra pequeña demo");
        String constantSentence = "una Compañia de Telefono";
        showOptions(new String[]{"crear " + constantSentence, "modificar " + constantSentence, "buscar " +
                constantSentence, "listar todas las Compañias", "eliminar " + constantSentence});

    }

    public boolean tryAgain() {
        System.out.println("Deseas Usar de Nuevo la Demo? si/no?");
        if (sc.next().toLowerCase().equals("no")) return false;
        return true;
    }
}

