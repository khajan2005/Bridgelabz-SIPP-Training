package SortingAlgorithem;
import java.util.*;

public class BubbleSort{
    public static void main(String[] args) {
        int[] marks = {88, 75, 92, 60, 85, 70};

        System.out.println("Original Marks: " + Arrays.toString(marks));
        bubbleSort(marks);

        System.out.println("Sorted Marks (Ascending): " + Arrays.toString(marks));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
