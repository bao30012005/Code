/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import bo.BaseConverter;
import bo.BaseConverter.Base;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Display d = new Display();
        BaseConverter converter = new BaseConverter();
        while (true) {
            Base inBase = d.getChoiceInput();
            if (inBase == null) {
                return;
            }
            String baseChar = BaseConverter.BASE_CHARACTER.substring(0, inBase.getBaseValue());
            String input = Validation.getStringByRegex("Enter input: ", "[" + baseChar + "]+", "Input character on set " + baseChar);
            Base outBase = d.getChoiceOutput(input);
            try {
                System.out.println("Result: " + converter.convert(input, inBase, outBase));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
