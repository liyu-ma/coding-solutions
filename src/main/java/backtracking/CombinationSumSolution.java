package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumSolution {
    // https://leetcode.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, 0, target);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> partial, int[] candidates, int from, int target) {
        if (target == 0) {
            res.add(partial);
        } else if (target > 0) {
            for (int i=from; i<candidates.length; i++) {
                if (candidates[i] <= target) {
                    List<Integer> updated = new ArrayList<>(partial);
                    updated.add(candidates[i]);
                    backtrack(res, updated, candidates, i, target - candidates[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{ 1,2,3,4 };
        int target = 6;

        CombinationSumSolution solution = new CombinationSumSolution();
        List<List<Integer>> ans = solution.combinationSum(candidates, target);

        for (List<Integer> group : ans) {
            group.forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
    }

}
