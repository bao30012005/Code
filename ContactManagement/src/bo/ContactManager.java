/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author Dell
 */
public class ContactManager {

    private final List<Contact> list;
    private int lastID;

    public ContactManager() {
        list = new ArrayList<>();
        lastID = 0;
    }

    public boolean addContact(Contact c) {
        c.setId(++lastID);
        return list.add(c);
    }

    public boolean checkEmpty() {
        return list.isEmpty();
    }

    public String getAllContactString() {
        String temp = "";
        for (Contact c : list) {
            temp += "\n" + c.toString();
        }

        return temp;

    }

    public int getContactByID(int id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Contact deleteContactByID(int id) throws Exception {
        int index = getContactByID(id);
        if (index != -1) {
            return list.remove(index);
        }
        throw new Exception("ID not found");
    }
}
