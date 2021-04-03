package offer.chapter05;

/**
 * 翻转单词的顺序VS左旋转字符串
 */
public class Problem05 {
    //旋转单词，如"I am Man"转换为"Man am I"
    public static char[] solution1(char[] arr) {
        if (arr == null || arr.length < 1)
            return arr;
        reverse(arr, 0, arr.length - 1);
        int lo = 0;
        int hi = 0;
        while (lo < arr.length) {
            if (arr[lo] == ' ') {
                lo++;
                hi++;
            } else if (hi == arr.length || arr[hi] == ' ') {
                reverse(arr, lo, hi - 1);
                hi++;
                lo = hi;
            } else {
                hi++;
            }
        }
        return arr;
    }

    public static void reverse(char[] arr, int start, int end) {
        if (arr == null || arr.length <= 1 || start < 0 || end > arr.length - 1 || start >= end) {
            return;
        }
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    //旋转左边字符串
    public static char[] solution2(char[] arr, int leftIndex) {
        if (arr == null || leftIndex < 0 || arr.length <= leftIndex)
            return arr;
        reverse(arr,0,leftIndex);
        reverse(arr,leftIndex+1,arr.length-1);
        reverse(arr,0,arr.length-1);
        return arr;
    }
}
