package leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 359 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4,2));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, 0, n, k, new Stack<>());
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int cur, int n, int k, Stack<Integer> stack) {
            if (stack.size() == k) {
                ans.add(new ArrayList<>(stack));
                return;
            }
            for (int i = cur + 1; i <= n - k + stack.size() + 1; i++) {
                stack.push(i);
                dfs(ans, i, n, k, stack);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}