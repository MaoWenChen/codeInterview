package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet39 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(combinationSum(candidates, 8));
    }

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0, candidates, target, 0, new ArrayList<>());
        return res;

    }

    public static void dfs(int cur, int[] candidates, int target, int sum, List<Integer> list) {
        if (cur >= candidates.length) {
            return;
        }
        if (sum == target) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
        } else if (sum < target) {
            list.add(candidates[cur]);
            dfs(cur, candidates, target, sum + candidates[cur], list);
            dfs(cur + 1, candidates, target, sum + candidates[cur], list);
            list.remove(list.size() - 1);
            dfs(cur + 1, candidates, target, sum, list);
        }
    }

}
