package SortingAlgorithem;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] employeeIDs = {104, 102, 109, 101, 105, 103};

        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending): " + Arrays.toString(employeeIDs));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
