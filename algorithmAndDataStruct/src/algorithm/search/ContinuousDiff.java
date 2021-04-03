package algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 */
public class ContinuousDiff {

    public int[] numsSameConsecDiff(int N, int K) {
        if (N==0) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, 0, K, list,N);
        int[] res = new int[list.size()];
        for(int i =0;i<res.length;i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public void dfs(int cur, int num, int k, List<Integer> list, int des) {
        if (cur==des) {
            list.add(num);
        }else {
            int tmp = num%10;
            for(int i = 0;i<=9;i++) {
                if (cur==0) {
                    if (i==0&&des>1) {
                        continue;
                    }
                    dfs(cur+1, i, k, list,des);
                    continue;
                }
                if(Math.abs(i-tmp)==k) {
                    dfs(cur+1, num*10+i, k, list,des);
                }
            }
        }
    }

}
