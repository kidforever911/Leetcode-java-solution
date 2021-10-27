public class Leetcode147 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null) return head;
            ListNode dummy = new ListNode();
            ListNode cur = head;
            ListNode pre = dummy;
            while(cur != null){
                ListNode next = cur.next;

                while(pre.next != null && pre.next.val < cur.val){
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = next;
            }
            return dummy.next;
        }
    }
}
