//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串
package leetcode.editor.cn;

import java.util.Stack;

public class BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //3+2*2
        //322*+
        //
        private Stack<String>stack=new Stack<>();
//    public int calculate(String s) {
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int i = 0; i <s.length() ; i++) {
//            if (s.charAt(i)==' '){
//                stringBuilder.append(s.charAt(i));
//            }
//        }
//        s=stringBuilder.toString();
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}