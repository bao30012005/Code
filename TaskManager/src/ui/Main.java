/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.TaskManagementController;
import java.util.HashMap;
import java.util.Map;
import model.Task;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        TaskManagementController control = new TaskManagementController();
        while (true) {
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("---------- Add Task ----------");
                    Task t = control.addTask();
                    if (t != null) {
                        System.out.println("Sucessful");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 2:
                    System.out.println("---------- Del Task ----------");
                    try {
                        Task delete = control.deleteTaskByID();
                        System.out.println("Successful");
                        System.out.println(delete);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("------------------------------------- Task -------------------------------------");
                    System.out.println(control.getDisplayAll());
                    break;
                case 4:
                    return;
                default:
                    throw new Exception("Error");
            }
        }

    }
}
