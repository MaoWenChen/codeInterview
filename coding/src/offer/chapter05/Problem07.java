package offer.chapter05;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。
 * 2～10为数字本身， A为1。 J为11、Q为12、 为13。大小王｛0表示｝可以看成任意数字。
 */
public class Problem07 {
    //此方法除0外其他数字不重复
    public static boolean solution1(int[] nums) {
        if (nums == null || nums.length < 5)
            return false;
        Arrays.sort(nums);
        int zeroNum = 0;
        while (zeroNum < nums.length && nums[zeroNum] == 0) {
            zeroNum++;
        }
        if (zeroNum >= nums.length || nums[nums.length - 1] - nums[zeroNum] <= nums.length) {
            return true;
        }
        return false;
    }

    //其他数字重复
    public static boolean solution2(int[] nums) {
        if (nums == null || nums.length < 5)
            return false;
        Arrays.sort(nums);
        int zeroNum = 0;
        while (zeroNum < nums.length && nums[zeroNum] == 0) {
            zeroNum++;
        }
        int small = zeroNum;
        int big = small + 1;
        int gap = 0;
        while (big < nums.length) {
            if (nums[small] == nums[big]) {
                return false;
            }
            gap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }
        return gap <= zeroNum;
    }
}
