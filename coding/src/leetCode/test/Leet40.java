package leetCode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet40 {
    public static void main(String[] args) {
        Leet40 leet = new Leet40();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs1(0, candidates, target, new ArrayList<>());
        return res;
    }

    public void dfs(int cur, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }

        } else {
            for (int i = cur; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                list.add(candidates[i]);
                dfs(i + 1, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public void dfs1(int cur, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
        } else {
            if (cur < candidates.length && candidates[cur] <= target) {
                list.add(candidates[cur]);
                dfs1(cur + 1, candidates, target - candidates[cur], list);
                list.remove(list.size() - 1);
                dfs1(cur + 1, candidates, target, list);
            }
        }
    }

}
