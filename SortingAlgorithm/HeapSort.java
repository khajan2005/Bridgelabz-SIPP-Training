package SortingAlgorithem;
import java.util.*;

public class HeapSort{
    public static void main(String[] args) {
        int[] salaries = {45000, 30000, 60000, 25000, 52000, 40000};

        System.out.println("Original Salary Demands: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted Salary Demands (Ascending): " + Arrays.toString(salaries));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            heapify(arr, size, largest);
        }
    }
}

