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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return head;
        int n = 0;
        for(ListNode p = head; p != null; p = p.next) {
            n ++;
        }
        if(n == 1) return null;
        int index = n / 2;
        ListNode cur = head;
        for(int i = 0; i < index - 1; i ++) {
            cur = cur.next;
        }
        if(cur.next != null) cur.next = cur.next.next;
        return head;
    }
}