public class FirstLastOccurence {
    public static int[] findFirstLast(int[] arr, int target) {
        int first = -1, last = -1;
        int left = 0, right = arr.length - 1;

        // Find first
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid - 1;
            else left = mid + 1;
            if (arr[mid] == target) first = mid;
        }

        left = 0; right = arr.length - 1;
        // Find last
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid - 1;
            if (arr[mid] == target) last = mid;
        }

        return new int[]{first, last};
    }
}