//给你一个字符串 s ，请你根据下面的算法重新构造字符串： 
//
// 
// 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。 
// 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。 
// 重复步骤 2 ，直到你没法从 s 中选择字符。 
// 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。 
// 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。 
// 重复步骤 5 ，直到你没法从 s 中选择字符。 
// 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。 
// 
//
// 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。 
//
// 请你返回将 s 中字符重新排序后的 结果字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aaaabbbbcccc"
//输出："abccbaabccba"
//解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
//第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
//第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
//第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
//第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
// 
//
// 示例 2： 
//
// 输入：s = "rat"
//输出："art"
//解释：单词 "rat" 在上述算法重排序以后变成 "art"
// 
//
// 示例 3： 
//
// 输入：s = "leetcode"
//输出："cdelotee"
// 
//
// 示例 4： 
//
// 输入：s = "ggggggg"
//输出："ggggggg"
// 
//
// 示例 5： 
//
// 输入：s = "spo"
//输出："ops"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
// Related Topics 排序 字符串 
// 👍 20 👎 0

  
  package leetcode.editor.cn;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IncreasingDecreasingString{
      public static void main(String[] args) {
           Solution solution = new Solution();
           System.out.println(solution.sortString("leetcode"));
      }
      static
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String sortString(String s) {
        TreeMap<Character,Integer>map=new TreeMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder ans=new StringBuilder();
        while (!map.isEmpty()){
            Set<Character> keys=map.keySet();
            for (char key:keys){
                ans.append(key);
                if (map.get(key)==1){
                    map.remove(key);
                }else {
                    map.put(key,map.get(key)-1);
                }
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }