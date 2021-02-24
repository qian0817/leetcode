package leetcode.editor.cn;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 865 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7},7));
        System.out.println(solution.combinationSum(new int[]{2,3,5},8));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans.clear();
            dfs(candidates, 0, target, new Stack<>(), 0);
            return ans;
        }

        private void dfs(int[] candidates, int cur, int target, Stack<Integer> stack, int value) {
            if (value == target) {
                ans.add(new ArrayList<>(stack));
                return;
            }
            if (value > target || cur == candidates.length) {
                return;
            }
            stack.push(candidates[cur]);
            dfs(candidates, cur, target, stack, value + candidates[cur]);
            stack.pop();
            dfs(candidates, cur + 1, target, stack, value);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}