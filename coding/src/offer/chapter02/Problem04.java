package offer.chapter02;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 调整数值，使基数位于偶数前面
 */
public class Problem04 {
    public static void solution(int[] num, Predicate test) {
        if (num == null || test == null || num.length < 2)
            return;

        int start = 0;
        int end = num.length - 1;
        int temp = num[start];
        while (start < end) {
            while (start < end && !test.test(num[end])) {
                end--;
            }
            num[start] = num[end];
            while (start < end && test.test(num[start])) {
                start++;
            }
            num[end] = num[start];
        }
        num[start] = temp;
    }

    class ReorderOddEven implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return (integer & 0x1) == 1;
        }
    }
}
