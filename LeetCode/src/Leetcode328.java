public class Leetcode328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode temp = even;
            while(even != null && even.next != null){
                odd.next = odd.next.next;
                even.next = even.next.next;
                even = even.next;
                odd = odd.next;
            }
            odd.next = temp;
            return head;
        }
    }
}
