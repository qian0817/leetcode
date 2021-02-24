package leetcode.editor.cn;

//给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 示例 1: 
//
// 输入: ["abcd","dcba","lls","s","sssll"]
//输出: [[0,1],[1,0],[3,2],[2,4]] 
//解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2: 
//
// 输入: ["bat","tab","cat"]
//输出: [[0,1],[1,0]] 
//解释: 可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串 
// 👍 95 👎 0

import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.palindromePairs(new String[]{"bat", "tab", "cat"}));

    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<String, Integer> indices = new HashMap<>();

        public List<List<Integer>> palindromePairs(String[] words) {
            int n = words.length;
            for (int i = 0; i < n; i++) {
                String reverse = new StringBuilder(words[i]).reverse().toString();
                indices.put(reverse, i);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String word = words[i];
                int m = word.length();
                for (int j = 0; j < m; j++) {
                    if (isPalindrome(word, j, m)) {
                        Integer index = indices.get(word.substring(i, j));
                        if (index != null && index != i) {
                            ans.add(Arrays.asList(i, index));
                        }
                    }
                    if (isPalindrome(word,0,j)){

                    }
                }
            }

            return ans;
        }

        private boolean isPalindrome(String word, int left, int right) {
            while (left < right) {
                if (word.charAt(left) != word.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}