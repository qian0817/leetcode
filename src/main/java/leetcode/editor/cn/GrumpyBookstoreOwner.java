//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 122 👎 0

package leetcode.editor.cn;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int ans = 0;
            int n = grumpy.length;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    ans += customers[i];
                }
            }
            int current = ans;
            int left = 0;
            int right = 0;
            while (right < n) {
                if (grumpy[right] == 1) {
                    current += customers[right];
                }
                if (right - left == X) {
                    if (grumpy[left] == 1) {
                        current -= customers[left];
                    }
                    left++;
                }
                right++;
                ans = Math.max(ans, current);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}