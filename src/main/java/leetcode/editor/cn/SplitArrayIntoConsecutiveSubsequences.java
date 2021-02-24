//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 225 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int n : nums) {
                if (!map.containsKey(n)) {
                    map.put(n, new PriorityQueue<>());
                }
                if (map.containsKey(n - 1)) {
                    int prevLength = map.get(n - 1).poll();
                    if (map.get(n - 1).isEmpty()) {
                        map.remove(n - 1);
                    }
                    map.get(n).offer(prevLength + 1);
                } else {
                    map.get(n).add(1);
                }
            }
            for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
                if (e.getValue().peek() < 3) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}