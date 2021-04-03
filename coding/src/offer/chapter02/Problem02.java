package offer.chapter02;

/**
 * 打印1到最大的n位数
 */
public class Problem02 {

    public static void solution(int n) {
        if (n < 1)
            throw new IllegalArgumentException("invalid input");
        int[] num = new int[n];
        printNums(num);
    }

    private static void printNums(int[] num) {
        while (addOne(num)) {
            printArr(num, 0);
            System.out.println();
        }
    }

    private static void printArr(int[] num, int pos) {
        if (pos == num.length || num[pos] == 0) {
            return;
        }
        printArr(num, pos + 1);
        System.out.print(num[pos]);
    }


    private static boolean addOne(int[] num) {
        int carry = 1;
        int pos = 0;
        for (; pos < num.length && carry != 0; pos++) {
            num[pos] += carry;
            carry = num[pos] / 10;
            num[pos] = num[pos] % 10;

        }
        if (pos == num.length && carry != 0) {
            return false;
        }
        return true;
    }
}
