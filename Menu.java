/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import utils.Validation;

/**
 *
 * @author Dell
 */
public class Menu {
    public int getChoice(){
        System.out.println("====== Caculate Program ======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        return Validation.getIntInRange("Enter your choice: ", "Choice must be a number", "Input number in from 1 to 4", 1, 4);
    }
}
