//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划
package leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if (n==0){
            return 0;
        }
        int[]sell=new int[n];
        int[]buy=new int[n];
        int[]cool=new int[n];
        buy[0]=-prices[0];
        for (int i = 1; i <n ; i++) {
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],cool[i-1]-prices[i]);
            cool[i]=Math.max(cool[i-1],Math.max(sell[i-1],buy[i-1]));
        }
        return sell[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}