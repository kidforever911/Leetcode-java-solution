public class Leetcode24 {
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
        //iteration
        //time complexity o(n)
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode res = new ListNode(0);
            res.next = head;
            ListNode cur = res;
            while (cur.next != null && cur.next.next != null) {
                ListNode next = head.next;
                ListNode temp = head.next.next;
                cur.next = next;
                next.next = head;
                head.next = temp;
                cur = head;
                head = head.next;
            }
            return res.next;
        }
    }


    //recursion
    //time complexity: o(n)
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
