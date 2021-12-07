/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplication(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        while(left.next != null){
            ListNode right = left.next;
            while(right != null && right.val == left.next.val) right = right.next;
            if(left.next.next == right) left = left.next;
            else left.next = right;
        }
        return dummy.next;
    }
}