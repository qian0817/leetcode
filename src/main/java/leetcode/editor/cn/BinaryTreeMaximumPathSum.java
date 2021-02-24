//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索
package leetcode.editor.cn;

import leetcode.TreeNode;

public class BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        System.out.println(solution.maxPathSum(new TreeNode(
                new Integer[]{1,2,3})));
    }
    

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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }

    private int solve(TreeNode root) {

        int cur=root.val;
        if (cur>ans){
            ans=cur;
        }
        if (root.left==null&&root.right==null){
            return root.val;
        }
        int left=0,right=0;
        if (root.left!=null) {
            left = solve(root.left);
        }
        if (root.right!=null) {
            right = solve(root.right);
        }
        int temp=Math.max(left+right+cur,Math.max(left+cur,right+cur));
        if (temp>ans){
            ans=temp;
        }
        return Math.max(cur+Math.max(left,right),cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}