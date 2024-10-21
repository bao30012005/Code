/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import model.Matrix;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        while (true) {
            System.out.println("====== Input Matrix ======");
            Matrix first = Validation.inputMatrix("MatrixA");
            Matrix second = Validation.inputMatrix("MatrixB");
            boolean checkOut = true;
            while (checkOut) {
                int choice = menu.getChoice();
                switch (choice) {
                    case 1:
                        try {
                        Matrix result = first.add(second);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 2:
                        try {
                        Matrix result = first.subtract(second);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 3:
                        try {
                        Matrix result = first.multiple(second);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case 4:
                        checkOut = false;
                        break;
                    default:
                        throw new Exception("Error");
                }
            }
            boolean con = Validation.getYNInput("Do you want to continue with anothor matrix (Y/N): ");
            if (!con) {
                return;
            }
        }
    }
}
