//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 240 👎 0


package leetcode.editor.cn;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root==null){
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right;
            }
            Node last = root;
            while (true) {
                Node begin = null;
                Node temp = last;
                while (temp != null) {
                    if (temp.left != null) {
                        if (temp.right != null) {
                            temp.left.next = temp.right;
                            solve(temp.right, temp.next);
                        } else {
                            solve(temp.left, temp.next);
                        }
                        begin = temp.left;
                        break;
                    } else if (temp.right != null) {
                        solve(temp.right, temp.next);
                        begin = temp.right;
                        break;
                    }
                    temp = temp.next;
                }
                if (begin == null) {
                    break;
                }
                last = begin;
            }
            return root;
        }

        private void solve(Node prev, Node last) {
            while (last != null) {
                if (last.left!=null){
                    prev.next=last.left;
                    prev=last.left;
                }
                if (last.right!=null){
                    prev.next=last.right;
                    prev=last.right;
                }
                last=last.next;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}