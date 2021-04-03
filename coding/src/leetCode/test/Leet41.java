package leetCode.test;

public class Leet41 {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] >= 0 && nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
                i--;
            }
        }
        while (start < nums.length && start == nums[start]) {
            start++;
        }
        return start;
    }
}
