//给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。 
//区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 
//
// 说明: 
//最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。 
//
// 示例: 
//
// 输入: nums = [-2,5,-1], lower = -2, upper = 2,
//输出: 3 
//解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 186 👎 0


package leetcode.editor.cn;

public class CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countRangeSum(new int[]{-2, 5, -1}, -2, 2);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long s = 0;
            long[] sum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                s += nums[i];
                sum[i + 1] = s;
            }
            return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
        }

        public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
            if (left == right) {
                return 0;
            } else {
                int mid = (left + right) / 2;
                int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
                int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
                int ret = n1 + n2;

                // 首先统计下标对的数量
                int i = left;
                int l = mid + 1;
                int r = mid + 1;
                while (i <= mid) {
                    while (l <= right && sum[l] - sum[i] < lower) {
                        l++;
                    }
                    while (r <= right && sum[r] - sum[i] <= upper) {
                        r++;
                    }
                    ret += r - l;
                    i++;
                }

                // 随后合并两个排序数组
                int[] sorted = new int[right - left + 1];
                int p1 = left, p2 = mid + 1;
                int p = 0;
                while (p1 <= mid || p2 <= right) {
                    if (p1 > mid) {
                        sorted[p++] = (int) sum[p2++];
                    } else if (p2 > right) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        if (sum[p1] < sum[p2]) {
                            sorted[p++] = (int) sum[p1++];
                        } else {
                            sorted[p++] = (int) sum[p2++];
                        }
                    }
                }
                for (int j = 0; j < sorted.length; j++) {
                    sum[left + j] = sorted[j];
                }
                return ret;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}