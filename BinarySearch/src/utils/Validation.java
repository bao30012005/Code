/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Validation {

    public final static Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput(String mess, String errorFormatNumber, int min, int max) {
        String input = null;
        while (true) {
            System.out.println(mess);
            input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.println("Input must be an integer between " + min + " and " + max + "!");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errorFormatNumber);
            }
        }
    }
}
