/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import model.Matrix;

/**
 *
 * @author Dell
 */
public class Validation {

    public final static Scanner sc = new Scanner(System.in);

    public static int getIntInRange(String mess, String errorFormat, String errorOutRange, int min, int max) {
        while (true) {
            System.out.print(mess);
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

    public static int getIntInput(String mess, String errorFormat) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(errorFormat);
            }
        }
    }

    public static Matrix inputMatrix(String matrixName) {
        int row = getIntInRange("Enter row " + matrixName + ": ", "Row of matrix must be a number", "Input a number from 1 to " + Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        int column = getIntInRange("Enter column " + matrixName + ": ", "Column of matrix must be a number", "Input a number from 1 to " + Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        Matrix m = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int value = Validation.getIntInput("Enter " + matrixName + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:", "Value of matrix is digit");
                m.setValueAt(i, j, value);
            }
        }
        return m;
    }
    
    public static boolean getYNInput(String mess){
        while(true){
            System.out.print(mess);
            String input = sc.nextLine().toUpperCase();
            if(input.equals("N")) return false;
            if(input.equals("Y")) return true;
            System.out.println("Please input (Y/y) for Yes or (N/n) for No");
        }
    }
}
