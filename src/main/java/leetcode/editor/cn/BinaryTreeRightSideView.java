//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索
package leetcode.editor.cn;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new LinkedList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<TreeNode>temp=new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode cur=queue.remove();
                if (cur.left!=null){
                    temp.add(cur.left);
                }
                if (cur.right!=null){
                    temp.add(cur.right);
                }
                if (queue.isEmpty()){
                    ans.add(cur.val);
                }
            }
            queue.addAll(temp);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}