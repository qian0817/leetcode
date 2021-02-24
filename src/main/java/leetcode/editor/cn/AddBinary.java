//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串
package leetcode.editor.cn;

public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("1","1"));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        StringBuilder ret=new StringBuilder();
        int temp=0;
        for (int i = 0; i <b.length(); i++) {
            int add=char2num(a.charAt(a.length()-i-1))+char2num(b.charAt(b.length()-i-1))+temp;
            temp=add/2;
            add%=2;
            ret.insert(0,add);
        }
        for (int i =b.length(); i <a.length(); i++) {
            int add=char2num(a.charAt(a.length()-i-1))+temp;
            temp=add/2;
            add%=2;
            ret.insert(0,add);
        }
        if (temp!=0) {
            ret.insert(0,temp);
        }
        return ret.toString();

    }
    private int char2num(char c){
        return c-'0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}