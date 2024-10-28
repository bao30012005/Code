/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.ContactInputter;
import bo.ContactManager;
import model.Contact;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class ContactManagementController {
    private ContactManager manager;
    private ContactInputter inputter;

    public ContactManagementController() {
        manager = new ContactManager();
    }
    
    public Contact addContact(){
        inputter = new ContactInputter();
        Contact c = inputter.inputContact();
        if(manager.addContact(c)){
            return c;
        }
        return null;
    }
    
    public String getStringDisplayAll(){
        String result = String.format(Validation.CONTACT_DISPLAY_FORMAT, "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        if(manager.checkEmpty()){
            result = "No have any contact";
        }
        else{
            result += manager.getAllContactString();
        }
        return result;
    }
    
    public Contact deleteContactByID() throws Exception{
        int id = Validation.getIntInputInRange("Input id to delete: ", "ID must be a number", "ID must be in range [1-" + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE);
        return manager.deleteContactByID(id);
    }
    
    
}
