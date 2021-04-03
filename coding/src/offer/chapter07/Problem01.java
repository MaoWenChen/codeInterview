package offer.chapter07;

/**
 * 数组中重复的数字(数组里的所有数字都在0到n-1的范围内)
 */
public class Problem01 {

    public static int solution(int[] arr) {
        if (arr == null || arr.length < 1)
            return -1;
        for (int i : arr) {
            if (i < 0 || i >= arr.length) {
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                int tmp = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = tmp;
            }
        }
        return -1;
    }
}
