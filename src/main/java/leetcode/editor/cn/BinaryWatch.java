//二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 案例: 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"] 
//
// 
//
// 注意事项: 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 
// Related Topics 位运算 回溯算法
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryWatch{
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        //System.out.println(solution.readBinaryWatch(2));
        List<String>s1=solution.readBinaryWatch(2);
        String[] s2={"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
        List<String>s3=Arrays.asList(s2);
        s1.sort((String::compareTo));
        s3.sort((String::compareTo));
        System.out.println(s1);
        System.out.println(s3);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String>ans=new LinkedList<>();
    public List<String> readBinaryWatch(int num) {
        solve(num,0 ,0,0,0);
        return ans;
    }

    private void solve(int num,int cur, int k, int hour, int minute) {
        if (hour>11||minute>59||k>num||10-cur<num-k){
            return;
        }
        if (k==num){
            ans.add(String.format("%d:%02d",hour,minute));
            return;
        }
        for (int i = cur; i <10 ; i++) {
            switch (i){
                case 0:
                    solve(num,i+1,k+1,hour+1,minute);
                    break;
                case 1:
                    solve(num,i+1,k+1,hour+2,minute);
                    break;
                case 2:
                    solve(num,i+1,k+1,hour+4,minute);
                    break;
                case 3:
                    solve(num,i+1,k+1,hour+8,minute);
                    break;
                case 4:
                    solve(num,i+1,k+1,hour,minute+1);
                    break;
                case 5:
                    solve(num,i+1,k+1,hour,minute+2);
                    break;
                case 6:
                    solve(num,i+1,k+1,hour,minute+4);
                    break;
                case 7:
                    solve(num,i+1,k+1,hour,minute+8);
                    break;
                case 8:
                    solve(num,i+1,k+1,hour,minute+16);
                    break;
                case 9:
                    solve(num,i+1,k+1,hour,minute+32);
                    break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}