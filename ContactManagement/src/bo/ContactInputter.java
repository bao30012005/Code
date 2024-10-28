/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import model.Contact;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class ContactInputter {

    private Contact c;

    public ContactInputter() {
        c = new Contact();
    }

    private void inputInformation() {
        c.setFullName(Validation.getStringByRegex("Input full name: ", "[A-Za-z ]+", "Fullname contain only alphabetic characters"));
        String[] nameWords = c.getFullName().split("\\s+");
        String lastName = nameWords[nameWords.length - 1];
        String firstName = "";
        for (int i = 0; i < nameWords.length - 1; i++) {
            firstName += nameWords[i] + " ";
        }
        c.setLastName(lastName);
        c.setFirstName(firstName.trim());
        c.setGroup(Validation.getStringByRegex("Input group: ", "[A-Za-z ]+", "Group contain only alphabetic characters"));
        c.setAddress(Validation.getStringByRegex("Input address: ", "[A-Za-z ]+", "Address contain only alphabetic characters"));
        c.setPhone(Validation.getPhoneNumber());
    }

    public Contact inputContact() {
        inputInformation();
        return c;
    }

}
