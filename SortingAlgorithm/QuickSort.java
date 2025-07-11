package SortingAlgorithem;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] prices = {1200, 750, 1999, 499, 999, 1450};

        System.out.println("Original Product Prices: " + Arrays.toString(prices));

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices (Ascending): " + Arrays.toString(prices));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
