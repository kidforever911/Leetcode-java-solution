public class Leetcode86 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode();
            ListNode dummy2 = new ListNode();
            ListNode cur1 = dummy1;
            ListNode cur2 = dummy2;
            while(head != null){
                if(head.val < x){
                    cur1.next = head;
                    cur1 = cur1.next;
                }else{
                    cur2.next = head;
                    cur2 = cur2.next;
                }
                head = head.next;
            }
            cur1.next = dummy2.next;
            cur2.next = null;
            return dummy1.next;
        }
    }
}
