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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        while(previous.next != null){
            ListNode next = previous.next.next;
            while(next != null && previous.next.val == next.val) next = next.next;
            if(previous.next.next == next) previous = previous.next;
            else previous.next = next;
        }
        return dummy.next;
    }
}