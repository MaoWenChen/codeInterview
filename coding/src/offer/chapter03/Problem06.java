package offer.chapter03;

/**
 * 二叉搜索树的后续遍历结果
 */
public class Problem06 {

    public static boolean solution(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        return verifySequenceOfBST(arr, 0, arr.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] arr, int start, int end) {
        if (start >= end) return true;

        int index = start;
        while (index < end - 1 && arr[index] < arr[end]) index++;
        int right = index;
        while (index < end - 1 && arr[index] > arr[end]) index++;
        if (index != end) return false;

        return verifySequenceOfBST(arr, start, right - 1) && verifySequenceOfBST(arr, right, end - 1);
    }

}
