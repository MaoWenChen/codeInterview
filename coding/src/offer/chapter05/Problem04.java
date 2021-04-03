package offer.chapter05;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的两个数字VS和为s的两个连续正数序列
 */
public class Problem04 {
    //在一个递增排序的数组中，查找两个和为s的数
    public static int[] solution1(int[] arr, int s) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException("invalid input");
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == s) {
                break;
            } else if (sum > s) {
                hi--;
            } else {
                lo++;
            }
        }
        return lo >= hi ? new int[0] : new int[]{arr[lo], arr[hi]};
    }

    //打印出所有和为s 的连续正数序列（至少两个数）
    public static List<List<Integer>> solution2(int s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s < 3)
            return res;
        int small = 1;
        int big = 2;
        int middle = (1 + s) / 2;
        int sum = small + big;
        while (small < middle) {
            if (sum == s) {
                List<Integer> r = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    r.add(i);
                }
                res.add(r);
            } else if (sum > s) {
                sum -= small;
                small++;
                continue;
            }
            big++;
            sum += big;

        }
        return res;
    }
}
