//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 165 👎 0


package leetcode.editor.cn;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageOfLevels(new TreeNode(new Integer[]{2147483647, 2147483647, 2147483647})));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Double> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                Queue<TreeNode> tempQueue = new LinkedList<>();
                long sum = 0;
                int size = queue.size();
                while (!queue.isEmpty()) {
                    TreeNode remove = queue.remove();
                    if (remove.left != null) {
                        tempQueue.add(remove.left);
                    }
                    if (remove.right != null) {
                        tempQueue.add(remove.right);
                    }
                    sum += remove.val;
                }
                ans.add(sum * 1.0 / size);
                queue.addAll(tempQueue);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}