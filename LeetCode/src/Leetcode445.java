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
//翻转做法
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preL1 = reverse(l1);
        ListNode preL2 = reverse(l2);
        int total = 0;
        ListNode dummy = new ListNode();
        while(preL1 != null || preL2 != null || total > 0) {
            if(preL1 != null) {
                total += preL1.val;
                preL1 = preL1.next;
            }
            if(preL2 != null) {
                total += preL2.val;
                preL2 = preL2.next;
            }
            ListNode cur = new ListNode(total % 10);
            total = total / 10;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}

//stack做法(不反转链表)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> recordL1 = new Stack<>();
        Stack<Integer> recordL2 = new Stack<>();
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        while(curL1 != null || curL2 != null) {
            if(curL1 != null) {
                recordL1.add(curL1.val);
                curL1 = curL1.next;
            }
            if(curL2 != null) {
                recordL2.add(curL2.val);
                curL2 = curL2.next;
            }
        }
        int total = 0;
        ListNode dummy = new ListNode();
        while(!recordL1.isEmpty() || !recordL2.isEmpty() || total > 0) {
            if(!recordL1.isEmpty()) {
                total += recordL1.pop();
            }
            if(!recordL2.isEmpty()) {
                total += recordL2.pop();
            }
            ListNode cur = new ListNode(total % 10);
            total /= 10;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}