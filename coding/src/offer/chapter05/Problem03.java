package offer.chapter05;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数组中只出现一次的数字
 */
public class Problem03 {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException("invalid input");
        int[] res = new int[2];
        int num = 0;
        for (int n : arr) {
            num ^= n;
        }
        int index = 0;
        while (num >>> 1 != 0 && index < 32) {
            index++;
        }
        for (int n : arr) {
            if ((n & 1 << index) != 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
