public class Leetcode206 {
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
    //iteration
        //complexity: o(n)
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            while(head != null && head.next != null){
                ListNode next = head.next;
                ListNode temp = dummy.next;
                head.next = head.next.next;
                dummy.next = next;
                next.next = temp;
            }
            return dummy.next;
        }
    }


    //recursion
    //time complexity: o(n)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
