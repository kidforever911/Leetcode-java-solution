public class Leetcode2 {
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
    //Iteration
        //time complexity : o(max(l1,l2))
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int next1 = 0;
            int total = 0;
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (l1 != null && l2 != null){
                total = l1.val + l2.val +next1;
                cur.next = new ListNode(total % 10);
                next1 = total / 10;
                l1 = l1.next;
                l2 = l2.next;
                cur = cur.next;
            }

            while (l1 != null){
                total = l1.val + next1;
                cur.next = new ListNode(total % 10);
                next1 = total / 10;
                l1 = l1.next;
                cur = cur.next;
            }

            while (l2 != null){
                total = l2.val + next1;
                cur.next = new ListNode(total % 10);
                next1 = total / 10;
                l2 = l2.next;
                cur = cur.next;
            }

            if(next1 != 0){
                cur.next = new ListNode(next1);
            }

            return dummy.next;
        }
    }


    //recursion
    //time complexity: o(max(l1,l2))
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int total = l1.val + l2.val;
            int next1 = total / 10;
            ListNode res = new ListNode(total % 10);
            if(l1.next != null || l2.next != null || next1 != 0){
                if(l1.next != null){
                    l1 = l1.next;
                } else{
                    l1 = new ListNode(0);
                }
                if(l2.next != null){
                    l2 = l2.next;
                } else{
                    l2 = new ListNode(0);
                }
                l1.val += next1;
                res.next = addTwoNumbers(l1, l2);
            }
            return res;

        }
    }
}
