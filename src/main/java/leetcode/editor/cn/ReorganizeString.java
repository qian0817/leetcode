//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 209 👎 0


package leetcode.editor.cn;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reorganizeString("aab");
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            if (S.length() <= 2) {
                return S;
            }
            int[] chars = new int[26];
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                chars[c - 'a']++;
                if (chars[c - 'a'] > (S.length() + 1) / 2) {
                    return "";
                }
            }
            char[] ans = new char[S.length()];
            int evenIndex = 0, oddIndex = 1;
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                while (chars[i] > 0  && chars[i] <= S.length()/2 && oddIndex < S.length()) {
                    ans[oddIndex] = c;
                    chars[i]--;
                    oddIndex += 2;
                }
                while (chars[i] > 0) {
                    ans[evenIndex] = c;
                    chars[i]--;
                    evenIndex += 2;
                }
            }
            return String.valueOf(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}