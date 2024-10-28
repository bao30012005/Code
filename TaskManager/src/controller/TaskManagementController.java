/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskInputter;
import bo.TaskManager;
import model.Task;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class TaskManagementController {
    private TaskInputter inputter;
    private TaskManager manager;

    public TaskManagementController() {
        manager = new TaskManager();
    }
    
    public Task addTask(){
        inputter = new TaskInputter();
        Task t = inputter.inputTask();
        if(manager.addTask(t)){
            return t;
        }
        return null;
    }
    
    public String getDisplayAll(){
        String result = String.format(Validation.DISPLAY_FORMAT, "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        if(manager.checkEmpty()){
            result = "No have any contact";
        }else{
            result += manager.getStringDisplayAll();
        }
        return result;
    }
    
    public Task deleteTaskByID() throws Exception{
        int id = Validation.getIntInRange("ID: ", "ID must be in range [1-" + Integer.MAX_VALUE + "]", "ID must be a positive number",1, Integer.MAX_VALUE);
        return manager.deleteTaskByID(id);
    }
}
