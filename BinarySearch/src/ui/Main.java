/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import bo.BinarySearch;
import utils.ArrayUtils;
import utils.Validation;

/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) {
        int arrayLength = Validation.getIntegerInput("Enter number of array:", "Length of array must be an positive integer", 1, Integer.MAX_VALUE);
        int searchValue = Validation.getIntegerInput("Enter search value:", "Search value must be an positive integer", 1, Integer.MAX_VALUE);
        int [] array = ArrayUtils.randomIntArray(arrayLength, 0, arrayLength);
        BinarySearch b = new BinarySearch(array);
        b.display(searchValue);
        
    }
}
