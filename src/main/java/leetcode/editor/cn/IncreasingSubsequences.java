package leetcode.editor.cn;

//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 125 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(nums, 0, Integer.MIN_VALUE);
            return ans;
        }

        private void dfs(int[] nums, int cur, int last) {
            if (cur== nums.length) {
                if (temp.size() >= 2) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            if (nums[cur] >= last) {
                temp.add(nums[cur]);
                dfs(nums, cur + 1, nums[cur]);
                temp.removeLast();
            }
            if (nums[cur] != last) {
                dfs(nums, cur + 1, last);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}