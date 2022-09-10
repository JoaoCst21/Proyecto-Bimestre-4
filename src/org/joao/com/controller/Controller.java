package org.joao.com.controller;

import org.joao.com.dao.PhoneCompanyDAO;
import org.joao.com.model.PhoneCompany;
import org.joao.com.view.Menu;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    PhoneCompanyDAO phoneCompanyDAO = new PhoneCompanyDAO();
    Menu menu = new Menu();

    public void pedirDatos() {
        do {
            menu.showMenu();
            int option = sc.nextInt();
            doAction(option);
        } while (menu.tryAgain());
    }

    private void doAction(int option) {
        switch (option) {
            case 1: {
                System.out.println("Ingrese El nombre de la Compañia de Telefono");
                String companyName = sc.next();
                // Validate Company Name
                phoneCompanyDAO.save(new PhoneCompany(0, companyName));
                break;
            }

            case 2: {
                System.out.println("Ingrese el id de la Compañia a buscar");
                int idCompany = sc.nextInt();
                PhoneCompany phoneCompany = phoneCompanyDAO.search(idCompany);
                System.out.println(phoneCompany.toString());
                if (!sure()) return;
                System.out.println("Ingrese los nuevos datos");
                System.out.println("Ingrese El nombre de la Compañia de Telefono");
                String companyName = sc.next();
                // Validate Company Name
                if (!sure()) return;
                phoneCompanyDAO.update(new PhoneCompany(idCompany, companyName));
                break;
            }
            case 3: {
                System.out.println("Ingrese el id de la Compañia a buscar");
                int idCompany = sc.nextInt();
                PhoneCompany phoneCompany = phoneCompanyDAO.search(idCompany);
                System.out.println(phoneCompany.toString());
                break;
            }
            case 4: {
                System.out.println("Espere mientras cargamos la Informacion");
                menu.showObjects(phoneCompanyDAO.readAll());
                break;
            }
            case 5: {
                System.out.println("ingrese el id de la Compañia de Telefono");
                int idCompany = sc.nextInt();
                PhoneCompany phoneCompany = phoneCompanyDAO.search(idCompany);
                System.out.println(phoneCompany.toString());
                if (!sure()) return;
                phoneCompanyDAO.delete(idCompany);
                break;
            }
        }
    }

    private boolean sure() {
        System.out.println("Esta seguro que desea proseguir? si/no");
        if (sc.next().toLowerCase().equals("si")) return true;
        return false;
    }
}
