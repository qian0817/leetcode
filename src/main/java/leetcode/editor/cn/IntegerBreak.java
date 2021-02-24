package leetcode.editor.cn;

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 285 👎 0

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(3));
        System.out.println(solution.integerBreak(5));
        System.out.println(solution.integerBreak(10));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}