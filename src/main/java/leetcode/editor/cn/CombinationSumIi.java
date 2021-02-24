//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 360 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
        System.out.println(solution.combinationSum2(new int[]{2,5,2,1,2},5));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ret = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            ret.clear();
            boolean[] used = new boolean[candidates.length];
            solve(candidates, target, 0, 0, new Stack<>(), used);
            return ret;
        }

        private void solve(int[] candidates, int target, int j, int cur, Stack<Integer> stack, boolean[] used) {
            if (cur > target) {
                return;
            }
            if (cur == target) {
                ret.add(new ArrayList<>(stack));
                return;
            }
            for (int i = j; i < candidates.length; i++) {
                if (i != 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                stack.push(candidates[i]);
                used[i] = true;
                solve(candidates, target, i + 1, cur + candidates[i], stack, used);
                used[i] = false;
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}