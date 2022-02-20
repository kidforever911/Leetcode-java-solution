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
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(head != null){
            int sum = 0;
            while(head.val != 0){
                sum += head.val;
                head = head.next;
            }
            if(sum != 0){
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}