package SortingAlgorithem;
import java.util.*;

public class SelectionSort{
    public static void main(String[] args) {
        int[] scores = {72, 85, 60, 90, 78, 66};

        System.out.println("Original Exam Scores: " + Arrays.toString(scores));

        selectionSort(scores);

        System.out.println("Sorted Exam Scores (Ascending): " + Arrays.toString(scores));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
