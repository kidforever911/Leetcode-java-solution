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
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(head != null || head2 != null){
            if(head != null){
                tail.next = head;
                tail = head;
                head = head.next;
            }
            if(head2 != null){
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        return;
    }

    private ListNode reverseList(ListNode l){
        ListNode cur = l;
        ListNode pre = null;
        while(cur != null){
            ListNode pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        return pre;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        int n = 0;
        for(ListNode p = head; p != null; p = p.next) n ++;
        ListNode cur = head;
        for(int i = 1; i < (n + 1) / 2; i ++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        next = reverseList(next);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(head != null || next != null){
            if(head != null){
                tail.next = head;
                tail = head;
                head = head.next;
            }
            if(next != null){
                tail.next = next;
                tail = next;
                next = next.next;
            }
        }
        return;
    }

    private ListNode reverseList(ListNode l){
        ListNode cur = l;
        ListNode pre = null;
        while(cur != null){
            ListNode pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        return pre;
    }
}