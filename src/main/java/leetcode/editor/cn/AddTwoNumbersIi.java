//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。 
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
// 
// Related Topics 链表
package leetcode.editor.cn;

import leetcode.ListNode;

public class AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        System.out.println(solution.addTwoNumbers(new ListNode(new int[]{7,2,4,3}),new ListNode(new int[]{3,5,6,4})));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1=0;
        int length2=0;
        ListNode cur1=l1;
        ListNode cur2=l2;
        while (cur1!=null){
            length1++;
            cur1=cur1.next;
        }
        while (cur2!=null){
            length2++;
            cur2=cur2.next;
        }
        if (length1>length2){
            for (int i = 0; i <length1-length2 ; i++) {
                ListNode temp=new ListNode(0);
                temp.next=l2;
                l2=temp;
            }
        }else if (length1<length2){
            for (int i = 0; i <length2-length1 ; i++) {
                ListNode temp=new ListNode(0);
                temp.next=l1;
                l1=temp;
            }
        }
        int n = solve(l1,l2);
        if (n!=0){
            ListNode temp=new ListNode(n);
            temp.next=l1;
            l1=temp;
        }
        return l1;
    }

    private int solve(ListNode l1, ListNode l2) {
        if (l1==null){
            return 0;
        }
        int n=solve(l1.next,l2.next);
        int ans=l1.val+l2.val+n;
        l1.val=ans%10;
        return ans/10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}