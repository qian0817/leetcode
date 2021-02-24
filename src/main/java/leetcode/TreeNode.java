package leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] nums) {
        if (nums.length == 0) {
            return;
        }
        val = nums[0];
        left = mkTreeHelper(nums, 1);
        right = mkTreeHelper(nums, 2);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            ret.append(temp.val).append(" ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return ret.toString();
    }

    private static TreeNode mkTreeHelper(Integer[] nums, int i) {
        if (i >= nums.length || nums[i] == null) {
            return null;
        }
        TreeNode ret = new TreeNode(nums[i]);
        ret.left = mkTreeHelper(nums, 2 * i + 1);
        ret.right = mkTreeHelper(nums, 2 * i + 2);
        return ret;
    }
}