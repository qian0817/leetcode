//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 389 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                    deque.pollLast();
                    k--;
                }
                deque.addLast(c);
            }
            for (int i = 0; i < k; i++) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                return "0";
            }
            boolean leadingZero = true;
            StringBuilder ans = new StringBuilder();
            while (!deque.isEmpty()) {
                char c = deque.pollFirst();
                if (leadingZero) {
                    if (c == '0') {
                        continue;
                    }
                    leadingZero = false;
                }
                ans.append(c);
            }
            return ans.length() == 0 ? "0" : ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}