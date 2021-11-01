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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(true){
            ListNode temp = cur;
            for(int i = 0; i < k && temp != null; i ++) {
                temp = temp.next;
            }
            if(temp == null) break;
            ListNode tempHead = cur.next;
            ListNode next = tempHead.next;
            for(int i = 0; i < k - 1; i ++){
                ListNode tempNext = next.next;
                next.next = tempHead;
                tempHead = next;
                next = tempNext;
            }
            ListNode curNext = cur.next;
            cur.next = tempHead;
            curNext.next = next;
            cur = curNext;


        }
        return dummy.next;

    }
}