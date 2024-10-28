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
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        int choice = Validation.getIntInputInRange("Enter choice: ", "Choice must be an integer. Enter again!", "Choice muts be an integer in range [1,4]. Enter again!", 1, 4);
        return choice;
    }
}
