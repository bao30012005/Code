/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Test {

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (Character.isLetter(s.charAt(i))) {
                int start = i;
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    i++;
                }
                String temp = s.substring(start, i);
                result.append(new StringBuilder(temp).reverse());
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        System.out.println(result.toString());
    }
}
