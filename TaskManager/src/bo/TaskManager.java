/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author Dell
 */
public class TaskManager {

    private List<Task> tasks;
    private int lastID;

    public TaskManager() {
        tasks = new ArrayList<>();
        lastID = 0;
    }

    public boolean addTask(Task t) {
        t.setId(++lastID);
        return tasks.add(t);
    }

    public int getTaskByID(int id) {
        int index = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Task deleteTaskByID(int id) throws Exception {
        int index = getTaskByID(id);
        if (index != -1) {
            return tasks.remove(index);
        }
        throw new Exception("ID not found");
    }

    public boolean checkEmpty() {
        return tasks.isEmpty();
    }

    public String getStringDisplayAll() {
        String result = "";
        for (Task t : tasks) {
            result += "\n" + t.toString();
        }
        return result;
    }
}
