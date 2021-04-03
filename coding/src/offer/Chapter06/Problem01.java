package offer.Chapter06;

/**
 * 把字符串转换成整数
 */
public class Problem01 {
    //更鲁棒的代码参考JDK
    public static int solution(char[] arr) {
        if (arr == null || arr.length < 1)
            throw new IllegalArgumentException("invalid input");
        boolean minus = false;
        int startIndex = 0;
        int res = 0;
        if (arr[0] == '+') {
            startIndex++;
        } else if (arr[0] == '-') {
            startIndex++;
            minus = true;
        }
        while (startIndex < arr.length) {
            if (arr[startIndex] >= '0' && arr[startIndex] <= '9') {
                res = res * 10 + arr[startIndex] - '0';
                startIndex++;
            } else {
                break;
            }
        }
        if (startIndex < arr.length) {
            throw new NumberFormatException("invalid input");
        }
        return minus ? -res : res;
    }

}
