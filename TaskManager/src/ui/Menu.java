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
    public int getChoice (){
        System.out.println("=========== Task Program ===========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        return Validation.getIntInRange("Enter your choice: ", "Input a number in range [1-4]", "Input must be a number ", 1, 4);
    }
}
