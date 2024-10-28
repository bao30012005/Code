/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            String[] tmp = s.split(",\\s");
            List<Integer> number = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                number.add(Integer.valueOf(tmp[j]));
            }
            list.add(number);
        }
        list.sort((List<Integer> o1, List<Integer> o2) -> {
            int compareFirst = Integer.compare(o1.get(1), o2.get(1));
            if (compareFirst == 0) {
                return Integer.compare(o1.get(2), o2.get(2));
            }
            return compareFirst;
        });
        List<Integer> result = new ArrayList<>();
        int time = -1;
        for(List<Integer> i : list){
            if(i.get(0) > time ){
                result.add(i.get(2));
                time = i.get(1);
            }
        }
        result.sort((o1, o2) -> o2-o1);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
            if(i!= result.size() -1){
                System.out.print(", ");
            }
        }
    }
}
