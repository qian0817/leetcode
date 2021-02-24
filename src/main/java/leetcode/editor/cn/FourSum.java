//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 595 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>>ret=new ArrayList<>();
            if (nums==null||nums.length<4){
                return ret;
            }
            Arrays.sort(nums);
            for (int i = 0; i <nums.length ; i++) {
                if (i>=1&&nums[i]==nums[i-1]){
                    continue;
                }
                for (int j = i+1; j <nums.length ; j++) {
                    int left=j+1;
                    int right=nums.length-1;
                    if (j>=i+2&&nums[j]==nums[j-1]){
                        continue;
                    }
                    while (left<right){
                        if (nums[i]+nums[j]+nums[left]+nums[right]<target){
                            left++;
                        }else if (nums[i]+nums[j]+nums[left]+nums[right]>target){
                            right--;
                        }else {
                            ArrayList<Integer>temp=new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[left]);
                            temp.add(nums[right]);
                            ret.add(temp);
                            while (left<right&&nums[left]==nums[left+1]){
                                left++;
                            }
                            while (left<right&&nums[right]==nums[right-1]){
                                right--;
                            }
                            left++;
                            right--;
                        }
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}