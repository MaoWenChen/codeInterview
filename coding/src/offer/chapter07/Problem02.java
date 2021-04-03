package offer.chapter07;

/**
 * 构建乘积数组（）
 */
public class Problem02 {
    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2)
            return null;
        int[] res = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }
        int tmp = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            tmp *= arr[i + 1];
            res[i] = res[i] * tmp;
        }
        return res;
    }
}
