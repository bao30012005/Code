/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import bo.BaseConverter.Base;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class Display {

    public Base getChoiceInput() {
        System.out.println("====== Choose base input ======");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexadecimal.");
        System.out.println("4. Exit");
        int choice = Validation.getIntInputInRange("Enter your choice: ", "You should enter a number", "Your choice must be a number in range [1-4]", 1, 4);
        switch (choice) {
            case 1:
                return Base.BINARY;
            case 2:
                return Base.DECIMAL;
            case 3:
                return Base.HEXADECIMAL;
            default:
                return null;
        }
    }

    public Base getChoiceOutput(String input) {
        System.out.println("====== Choose base output ======");
        System.out.println("1. Convert " + input + " to binary.");
        System.out.println("2. Convert " + input + " to decimal.");
        System.out.println("3. Convert " + input + " to hexadecimal.");
        int choice = Validation.getIntInputInRange("Enter your choice: ", "You should enter a number", "Your choice must be a number in range [1-3]", 1, 3);
        switch (choice) {
            case 1:
                return Base.BINARY;
            case 2:
                return Base.DECIMAL;
            case 3:
                return Base.HEXADECIMAL;
            default:
                return null;
        }
    }

}
