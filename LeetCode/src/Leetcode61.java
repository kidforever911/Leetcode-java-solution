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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int n = 0;
        ListNode tail = new ListNode();
        ListNode cur = head;
        while(cur != null){
            n++;
            tail = cur;
            cur = cur.next;
        }
        k = k % n;
        if(k == 0) return head;

        ListNode prev = head;
        for(int i = 0; i < n - k - 1; i ++){
            prev = prev.next;
        }
        tail.next = head;
        head = prev.next;
        prev.next = null;
        return head;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k; i ++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}