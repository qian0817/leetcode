package leetcode.editor.cn;

//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 310 👎 0

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> nums = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
            int[] temp = new int[n];
            temp[0] = 1;
            for (int i = 1; i < n; i++) {
                temp[i] = temp[i - 1] * i;
            }
            k--;
            StringBuilder ans = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                int index = k / temp[i];
                k -= index * temp[i];
                ans.append(nums.get(index));
                nums.remove(index);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}