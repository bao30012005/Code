/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp % 2 == 0) {
                even.add(tmp);
            } else {
                odd.add(tmp);
            }
        }
        if (even.isEmpty() || odd.isEmpty()) {
            System.out.println("0");
        } else {
            int d = (int) Math.pow(10, 9) + 7;
            long oddSum = 0, evenSum = 0;
            for (int i = 0; i < odd.size(); i++) {
                oddSum += (1l * odd.get(i) * even.size()) % d;
                oddSum = oddSum % d;
            }
            for (int i = 0; i < even.size(); i++) {
                evenSum += (1l * even.get(i) * odd.size()) % d;
                evenSum = evenSum % d;
            }
            System.out.println((evenSum + oddSum) % d);
        }
    }
}
