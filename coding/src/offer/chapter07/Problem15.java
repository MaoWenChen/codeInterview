package offer.chapter07;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class Problem15 {
    public static int[] solution(int[] arr, int size) {
        if (arr == null || size < 1 || arr.length < size)
            throw new IllegalArgumentException("invalid input");
        int[] w = new int[arr.length - size + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && arr[i] >= deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = size; i < arr.length; i++) {
            w[i - size] = arr[deque.peekFirst()];
            while (!deque.isEmpty() && arr[i] >= deque.peekLast()) {
                deque.removeLast();
            }
            //删除不在窗口中的数
            if (!deque.isEmpty() && deque.peekFirst() <= i - size) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        w[w.length - 1] = arr[deque.getFirst()];
        return w;
    }
}
