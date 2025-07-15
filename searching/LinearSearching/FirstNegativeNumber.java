public class FirstNegativeNumber {
    public static int firstNegativeIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -3, 7};
        System.out.println("First negative index: " + firstNegativeIndex(arr));
    }
}