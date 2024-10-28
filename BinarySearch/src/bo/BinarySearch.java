/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.Arrays;
import utils.ArrayUtils;

/**
 *
 * @author Dell
 */
public class BinarySearch {

    private int[] array;

    public BinarySearch(int[] array) {
        Arrays.sort(array);
        this.array = array;
    }

    public int serch(int number) {
        int index = -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > number) {
                right = mid - 1;
            } else if (array[mid] < number) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

    public void display(int number) {
        int index = serch(number);
        System.out.print("Sorted array: ");
        ArrayUtils.displayIntArray(array);
        System.out.println();
        if (index == -1) {
            System.out.println("Value not exits");
        } else {
            System.out.println("Found " + number + " at index: " + index);
        }
    }
}
