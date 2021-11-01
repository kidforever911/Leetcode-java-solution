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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        for (int i = 0; i < n + 1; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        ListNode next = left.next;
        left.next = next.next;

        return dummy.next;
    }
}



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        int n = 0;
        for(ListNode i = dummy; i != null; i = i.next) n++;
        for(int i = 0; i < n - k - 1; i ++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;

    }
}
