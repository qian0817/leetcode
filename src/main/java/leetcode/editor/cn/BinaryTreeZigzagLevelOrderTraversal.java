//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索
package leetcode.editor.cn;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        System.out.println(solution.zigzagLevelOrder(new TreeNode(new Integer[]{3,9,20,1,null,15,7,8,9})));
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode>list=new LinkedList<>();
        LinkedList<TreeNode>temp=new LinkedList<>();
        List<List<Integer>>ret=new LinkedList<>();
        if (root==null){
            return ret;
        }
        boolean leftToRight=true;
        list.add(root);
        while (!list.isEmpty()){
            List<Integer>addList=new LinkedList<>();
            while (!list.isEmpty()){
                TreeNode node;
                node=list.removeLast();
                if (leftToRight){
                    if (node.left!=null)
                        temp.add(node.left);
                    if (node.right!=null)
                        temp.add(node.right);
                }else {
                    if (node.right!=null)
                        temp.add(node.right);
                    if (node.left!=null)
                        temp.add(node.left);
                }
                addList.add(node.val);
            }
            list=temp;
            temp=new LinkedList<>();
            ret.add(addList);
            leftToRight=!leftToRight;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}