package offer.chapter04;

import sun.security.util.Length;

/**
 * 数组中的逆序对
 */
public class Problem08 {

    public static int solution(int[] arr) {
        if (arr == null || arr.length < 1)
            throw new IllegalArgumentException("invalid input");
        int[] merge = new int[arr.length];
        System.arraycopy(arr, 0, merge, 0, arr.length);
        return mergeCount(arr, merge, 0, arr.length - 1);
    }

    private static int mergeCount(int[] arr, int[] merge, int start, int end) {
        if (start >= end)
            return 0;
        int mid = start + (end - start) / 2;

        int leftCount = mergeCount(merge, arr, start, mid);
        int rightCount = mergeCount(merge, arr, mid + 1, end);
        int left = mid;
        int right = end;
        int index = end;
        int count = 0;
        while (left >= start && right > mid) {
            if (arr[left] > arr[right]) {
                merge[index--] = arr[left--];
                count += (right - mid);
            } else {
                merge[index--] = arr[right--];
            }
        }

        while (left > start) {
            merge[index--] = arr[left--];
        }
        while (right > mid) {
            merge[index--] = arr[right--];
        }
        return count+leftCount+rightCount;
    }

}
