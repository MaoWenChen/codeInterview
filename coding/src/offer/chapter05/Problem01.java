package offer.chapter05;

import jdk.nashorn.internal.ir.IfNode;

/**
 * 数字在排序数组中出现的次数
 */
public class Problem01 {

    public static int solution(int[] arr, int k) {
        int number = 0;
        if (arr != null && arr.length > 0) {
            int firstK = getFirstK(arr, k, 0, arr.length - 1);
            int lastK = getLastK(arr, k, 0, arr.length - 1);
            if (firstK != -1 && lastK != -1) {
                number = lastK - firstK + 1;
            }
        }
        return number;
    }

    private static int getFirstK(int[] arr, int k, int start, int end) {
        if (arr == null || start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (arr[mid] == k) {
                if (mid > 0 && arr[mid - 1] != k || mid == 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int getLastK(int[] arr, int k, int start, int end) {
        if (arr == null || start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        while (start <= end) {

            if (arr[mid] == k) {
                if (mid + 1 < end && arr[mid + 1] != k || mid == end) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
