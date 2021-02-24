package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 36 👎 0

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder ans = new StringBuilder();
            s.chars().forEach(c -> {
                if (c == ' ') {
                    ans.append("%20");
                } else {
                    ans.append((char)c);
                }
            });
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}