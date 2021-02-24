//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 174 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
        System.out.println(solution.combinationSum3(3,9));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(0, k, n, new Stack<>(), ans);
            return ans;
        }

        private void dfs(int currentValue, int k, int n, Stack<Integer> stack, List<List<Integer>> ans) {
            if (currentValue > n) {
                return;
            }
            if (currentValue == n) {
                if (stack.size() == k) {
                    ans.add(new ArrayList<>(stack));
                } else {
                    return;
                }
            }
            int start = stack.size() == 0 ? 0 : stack.peek();
            for (int i = start + 1; i <= 9; i++) {
                stack.push(i);
                dfs(currentValue + i, k, n, stack, ans);
                stack.pop();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}