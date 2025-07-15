import java.util.Arrays;
public class LinearBinaryChallenge {
    public static int firstMissingPositive(int[] arr) {
        Arrays.sort(arr);
        int smallest = 1;
        for (int value : arr) {
            if (value == smallest) smallest++;
        }
        return smallest;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}