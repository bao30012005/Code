/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import model.Task;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class TaskInputter {

    private Task t;

    public TaskInputter() {
        t = new Task();
    }

    private void inputInfomation() {
        t.setRequirementName(Validation.getStringByRegex("Requirement Name: ", "Requirement name contain only alphabetic characters", "[A-Za-z ]+"));
        t.setTaskTypeID(Validation.getTaskTypeID());
        t.setDate(Validation.getInputDate("Date: ", "Input must be in format [dd-MM-yyyy]"));
        t.setPlanFrom(Validation.getPlanTime("From: ", "Plan time must be from 8.0, 8.5, 9.0, ..., 17.5"));
        t.setPlanTo(Validation.getPlanTimeTo("To: ", "Plan time must be from 8.0, 8.5, 9.0, ..., 17.5 and greter than " + t.getPlanFrom() , t.getPlanFrom()));
        t.setAssignee(Validation.getStringByRegex("Enter asignee name: ", "Name should contain only letter. Enter again: ", "[A-Za-z ]+"));
        t.setReviewer(Validation.getStringByRegex("Enter reviewer name: ", "Name should contain only letter. Enter again: ", "[A-Za-z ]+"));
    }
    
    public Task inputTask(){
        inputInfomation();
        return t;
    }

}
