package SortingAlgorithem;

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        int[] ages = {12, 14, 11, 10, 15, 14, 13, 12, 18, 11};

        System.out.println("Original Student Ages: " + Arrays.toString(ages));

        int[] sortedAges = countingSort(ages, 10, 18);

        System.out.println("Sorted Student Ages (Ascending): " + Arrays.toString(sortedAges));
    }

    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int age : arr) {
            count[age - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return output;
    }
}

