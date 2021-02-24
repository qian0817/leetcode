//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树
package leetcode.editor.cn;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
    List<Integer>ans=new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }

    private void solve(TreeNode root) {
        if (root==null){
            return;
        }
        ans.add(root.val);
        solve(root.left);
        solve(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}