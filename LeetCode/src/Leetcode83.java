public class Leetcode83 {
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
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            if(head == null || head.next == null) return head;
            dummy.next = head;
            while(head.next != null){
                if(head.val == head.next.val){
                    head.next = head.next.next;
                }else{
                    head = head.next;
                }
            }
            return dummy.next;
        }
    }

    //recursive
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            head.next = deleteDuplicates(head.next);
            return head.next.val == head.val? head.next : head;
        }
    }
}
