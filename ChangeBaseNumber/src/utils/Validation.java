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

    public final static Scanner sc = new Scanner(System.in);

    public static String getStringByRegex(String mess, String regex, String errorFormat) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine().toUpperCase();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println(errorFormat);
        }
    }

    public static int getIntInputInRange(String mess, String errorFormat, String errorOutRange, int min, int max) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.println(errorOutRange);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errorFormat);
            }
        }
    }

}
