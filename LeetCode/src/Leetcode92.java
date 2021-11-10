
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        for (int i = 0; i < right - left; i++) {
            //代码规范、规律：
            //一个值赋值给另一个值，那么前面不能改变这个值
            //例如：a.next = b.next; b.next  = c.next; c.next = d; d = e.next
            //类似套娃，防止出现List内部出现循环。
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        for (int i = 0; i < left - 1; i++) previous = previous.next;
        ListNode a = previous.next;
        ListNode b = a.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }
        previous.next.next = b;
        previous.next = a;
        return dummy.next;
    }
}
