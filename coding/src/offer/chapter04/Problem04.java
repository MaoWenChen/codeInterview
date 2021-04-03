package offer.chapter04;

/**
 * 求从1 到n这n个整数的十进制表示中1 出现的次数
 */
public class Problem04 {

    public static int solution(int n) {
        if (n < 1) throw new IllegalArgumentException("invalid input");

        char[] nums = String.valueOf(n).toCharArray();


        return numberOf1(nums, 0);
    }

    private static int numberOf1(char[] nums, int cur) {
        if (nums == null || nums.length <= cur || cur < 0) return 0;

        int first = nums[cur] - '0';
        int length = nums.length - cur;

        if (length == 1 && first == 0)
            return 0;
        if (length == 1 && first > 0)
            return 1;
        //numFirstDigit求 10000-19999中第一位为1的数目
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = power(length - 1);
        } else if (first == 1) {
            numFirstDigit = atoi(nums, cur + 1) + 1;
        }

        int numOtherDigit = first * (length - 1) + power(length - 2);
        int numRecursive = numberOf1(nums, cur + 1);

        return numFirstDigit + numOtherDigit + numRecursive;

    }

    public static int power(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    private static int atoi(char[] numbers, int i) {
        int result = 0;
        for (int j = i; j < numbers.length; j++) {
            result = (result * 10 + (numbers[j] - '0'));
        }
        return result;
    }
}
