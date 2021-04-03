package offer.chapter03;

/**
 * 字符串的排列
 */
public class Problem10 {
    public static void solution(char[] arr) {
        if (arr == null || arr.length < 1) return;
        permutation(arr, 0);
    }

    public static void permutation(char[] chars, int begin) {

        if (chars.length  == begin) {
            System.out.print(new String(chars) + " ");
        } else {
            char tmp;
            for (int i = begin; i < chars.length; i++) {

                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                permutation(chars, begin + 1);
            }
        }
    }


}
