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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            ListNode next = cur.next;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}


class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = head;
        while(tail.next != null){
            ListNode next = tail.next;
            if(next.val >= tail.val){
                tail = tail.next;
                continue;
            }
            ListNode cur = dummy;
            while(cur.next.val < next.val) cur = cur.next;
            tail.next = next.next;
            next.next = cur.next;
            cur.next = next;
        }
        return dummy.next;
    }
}

