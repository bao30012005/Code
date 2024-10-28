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
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        long maxCurrent = arr[0];
        long maxSoFar = arr[0];
        int start = 0;
        int end = 0;
        for(int i = 1; i < arr.length; i++){
            maxCurrent = Math.max(maxCurrent + arr[i], arr[i]);
            if(maxCurrent == maxSoFar){
                end = i;
            }
            maxSoFar = Math.max(maxSoFar, maxCurrent);
            
        }
    }
}
