package offer.chapter07;

/**
 * 表示数值的字符串
 */
public class Problem04 {
    public static boolean solution(char[] arr) {
        if (arr == null || arr.length <= 0)
            return false;
        int index = 0;
        if (arr[index] == '+' || arr[index] == '-')
            index++;
        if (index == arr.length)
            return false;
        boolean numeric = true;
        index = scanDigits(arr, index);
        if (index < arr.length) {
            //如果是小数
            if (arr[index] == '.') {
                index = scanDigits(arr, index + 1);
                if (index < arr.length && (arr[index] == 'E' || arr[index] == 'e'))
                    numeric = isExponential(arr, index + 1);
            } else if (arr[index] == 'e' || arr[index] == 'E') {
                numeric = isExponential(arr, index + 1);
            } else {
                numeric = false;
            }
        }
        return index == arr.length && numeric;
    }

    private static boolean isExponential(char[] arr, int index) {
        if (index >= arr.length)
            return false;
        if (arr[index] == '+' || arr[index] == '-')
            index++;
        if (index < arr.length) {
            index = scanDigits(arr, index);
            if (index == arr.length)
                return true;
        }
        return false;
    }

    private static int scanDigits(char[] arr, int index) {
        while (index < arr.length && arr[index] <= '9' && arr[index] >= '0')
            index++;
        return index;
    }


}
