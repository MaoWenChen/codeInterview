package offer.chapter01;

/**
 * 旋转数组的最小数（旋转数组是排序数组旋转而来，数组中可能存在重复的数）
 */
public class Problem07 {

    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid input.");
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = start;
        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = start + (end - start) / 2;
            if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                return getMin(arr, start, end);
            }
            if (arr[mid] >= arr[start]) {
                start = mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid;
            }
        }
        return arr[mid];
    }

    private static int getMin(int[] arr, int start, int end) {
        int min = arr[start];
        for (int i = start + 1; i <= end; i++) {
            min = arr[i] < min ? arr[i] : min;
        }
        return min;
    }
}
