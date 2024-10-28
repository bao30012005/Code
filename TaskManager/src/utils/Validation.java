    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Validation {

    public final static Scanner sc = new Scanner(System.in);
    public final static String PLAN_REGEX = "[0-9]{1,2}(\\.0|\\.5){1}";
    public final static String DISPLAY_FORMAT = "%-4s%-15s%-15s%-15s%-15s%-15s%-15s";

    public static int getIntInRange(String mess, String errorOutOfRange, String errorFormat, int min, int max) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.println(errorOutOfRange);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(errorFormat);
            }
        }
    }

    public static String getStringByRegex(String mess, String errorFormat, String regex) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println(errorFormat);
        }
    }

    public static String getTaskTypeID() {
        while (true) {
            System.out.println("LIST OF TASK TYPE: ");
            System.out.println("1. Code");
            System.out.println("2. Test");
            System.out.println("3. Design");
            System.out.println("4. Review");
            int input = getIntInRange("Task Type: ", "Please enter a valid integer!", "Please input interger number in range [1,4]", 1, 4);
            String result = null;
            switch (input) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Manager";
                    break;
                case 4:
                    result = "Learn";
            }
            return result;
        }
    }

    public static String getInputDate(String mess, String errorDateFormat) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, format);
                if (!input.equals(date.format(format))) {
                    throw new DateTimeParseException("Ngày không hợp lệ", input, 0);
                }
                String result = date.format(format);
                return result;
            } catch (DateTimeParseException e) {
                System.out.println(errorDateFormat);
            }
        }
    }

    public static void main(String[] args) {
        String input = getInputDate("Enter: ", "Error");
    }

    public static String getPlanTime(String mess, String errorFormatNumber) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine().trim();
            if (input.matches(PLAN_REGEX) && Double.parseDouble(input) >= 8.0 && Double.parseDouble(input) <= 17.5) {
                return input;
            } else {
                System.out.println(errorFormatNumber);
            }
        }
    }

    public static String getPlanTimeTo(String mess, String errorFormatNumber, String planFrom) {
        double from = Double.parseDouble(planFrom);
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine().trim();
            if (input.matches(PLAN_REGEX) && Double.parseDouble(input) >= 8.0 && Double.parseDouble(input) <= 17.5 && Double.parseDouble(input) > from) {
                return input;
            } else {
                System.out.println(errorFormatNumber);
            }
        }
    }
}
