package algorithm.search;

/**
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] index = new int[2];
        int left = -1;
        int rigth = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (start == mid || (mid > start && nums[mid - 1] != target)) {
                    left = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (left != -1) {
            start = 0;
            end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    if (end == mid || (mid < end && nums[mid + 1] != target)) {
                        rigth = mid;
                        break;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        index[0] = left;
        index[1] = rigth;
        return index;
    }
}
