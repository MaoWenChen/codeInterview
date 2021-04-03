package offer.chapter04;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 */
public class Problem02 {

    public static int[] solution1(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("invalid input");
        }
        int index = partition(arr, 0, arr.length - 1);
        while (index != k - 1) {
            if (index < k - 1) {
                index = partition(arr, index + 1, arr.length - 1);
            } else {
                index = partition(arr, 0, index - 1);
            }
        }
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = arr[i];
        }
        return out;

    }

    //使用小顶堆
    public static int[] solution2(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("invalid input");
        }
        Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : arr) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                int top = heap.peek();
                if (top > num) {
                    heap.remove();
                    heap.add(num);
                }
            }
        }
        int[] out = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            out[i] = heap.remove();
        }
        return out;
    }


    public static int partition(int[] arr, int start, int end) {
        if (end >= start) {
            return start;
        }
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= arr[tmp]) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }
}
