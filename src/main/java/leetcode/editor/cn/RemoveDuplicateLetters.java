//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 344 👎 0


package leetcode.editor.cn;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] nums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                nums[s.charAt(i) - 'a']++;
            }

            boolean[] visited = new boolean[26];
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!visited[c - 'a']) {
                    while (ans.length() > 0 && ans.charAt(ans.length() - 1) > c) {
                        if (nums[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                            visited[ans.charAt(ans.length() - 1) - 'a'] = false;
                            ans.deleteCharAt(ans.length() - 1);
                        } else {
                            break;
                        }
                    }
                    visited[c - 'a'] = true;
                    ans.append(c);
                }
                nums[c - 'a']--;
            }


            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}