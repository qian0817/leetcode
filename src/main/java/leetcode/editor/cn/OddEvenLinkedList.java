//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 312 👎 0


package leetcode.editor.cn;

import leetcode.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int i = 0;
            ListNode ret1 = head;
            ListNode temp = head.next;
            head.next = null;
            head = temp;
            ListNode ret2 = head;
            temp = head.next;
            head.next = null;
            head = temp;
            ListNode cur1 = ret1;
            ListNode cur2 = ret2;
            while (head != null) {
                i++;
                temp = head.next;
                head.next = null;
                if (i % 2 == 1) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                }
                head = temp;
            }
            cur1=ret1;
            while (cur1.next!=null){
                cur1=cur1.next;
            }
            cur1.next = ret2;
            return ret1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}