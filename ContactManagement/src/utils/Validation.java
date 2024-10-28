/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;
import model.Contact;

/**
 *
 * @author Dell
 */
public class Validation {

    public static final Scanner sc = new Scanner(System.in);
    public static final String PHONE_REGEX_COMBINED = "^(\\d{3}-\\d{3}-\\d{4} ((x|ext)\\d{4})?||\\d{3} \\d{3} \\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4})$";
    public static final String CONTACT_DISPLAY_FORMAT = "%-4s%-20s%-15s%-15s%-15s%-15s%-15s";
    public static String getStringByRegex(String mess, String regex, String errorFormat) {
        String input = null;
        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println(errorFormat);
        }
    }
    
    public static String getPhoneNumber(){
        while(true){
            System.out.print("Enter Phone: ");
            String input = sc.nextLine();
            if(input.matches(PHONE_REGEX_COMBINED)){
                return input;
            }
            System.out.println("Please input Phone flow");
            System.out.println("1234567890");
            System.out.println("123-456-7890");
            System.out.println("123-456-7890 x1234");
            System.out.println("123-456-7890 ext1234");
            System.out.println("(123)-456-7890");
            System.out.println("123.456.7890");
            System.out.println("123 456 7890");
        }
    }
    
    public static int getIntInput(String mess, String errorFormat){
        while(true){
            System.out.print(mess);
            String input = sc.nextLine();
            try{
                int number = Integer.parseInt(input);
                return number;
            }catch(NumberFormatException e){
                System.out.println(errorFormat);
            }
        }
    }
    
    public static int getIntInputInRange(String mess, String errorFormat, String errorOutOfRange, int min, int max){
        while(true){
            System.out.print(mess);
            while(true){
                String input = sc.nextLine();
                try{
                    int number = Integer.parseInt(input);
                    if(number < min || number > max){
                        System.out.println(errorOutOfRange);
                        continue;
                    }
                    return number;
                }catch(NumberFormatException e){
                    System.out.println(errorFormat);
                }
            }
        }
    }
}
