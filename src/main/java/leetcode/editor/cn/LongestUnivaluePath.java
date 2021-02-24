package leetcode.editor.cn;

//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 342 👎 0

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(new TreeNode(new Integer[]{5, 4, 5, 1, 1, null, 5})));
        System.out.println(solution.longestUnivaluePath(new TreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5})));
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
        Map<TreeNode, Integer> map = new HashMap<>();

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = longestPath(root.left, root.val) + longestPath(root.right, root.val);
            ans = Math.max(ans, longestUnivaluePath(root.left));
            ans = Math.max(ans, longestUnivaluePath(root.right));
            return ans;
        }

        public int longestPath(TreeNode root, int value) {
            if (root == null) {
                return 0;
            }
            if (map.containsKey(root)) {
                return map.get(root);
            }
            int ans;
            if (root.val == value) {
                ans = Math.max(longestPath(root.left, value), longestPath(root.right, value)) + 1;
            } else {
                ans = 0;
            }
            map.put(root, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}