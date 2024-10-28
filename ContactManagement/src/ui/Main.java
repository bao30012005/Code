/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.ContactManagementController;
import model.Contact;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        ContactManagementController control = new ContactManagementController();
        while (true) {
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("-------- Add a Contact --------");
                    Contact c = control.addContact();
                    if (c != null) {
                        System.out.println("Successful");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------- Display all Contact ----------------------------");
                    System.out.println(control.getStringDisplayAll());
                    break;
                case 3:
                    try {
                    Contact delete = control.deleteContactByID();
                    System.out.println("Successful");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                case 4:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
