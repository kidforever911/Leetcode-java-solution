public class Leetcode19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null) return head;
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = dummy;
            for(int i = 0; i < n + 1; i++){
                right = right.next;
            }
            while(right != null){
                left = left.next;
                right = right.next;
            }
            ListNode next = left.next;
            left.next = next.next;

            return dummy.next;
        }
    }
}
