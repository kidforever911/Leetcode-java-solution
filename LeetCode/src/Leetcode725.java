public class Leetcode725 {
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] result = new ListNode[k];
            int length = getsize(head);
            int sub = length/k;
            int reminder = length % k;
            ListNode cur = head;
            ListNode pre = new ListNode();
            for(int i = 0; cur != null && i < k; i++, reminder--){
                result[i] = cur;
                for(int j = 0; j < sub + (reminder > 0? 1 : 0); j++){
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = null;
            }
            return result;

        }

        private int getsize(ListNode head){
            int length = 0;
            while(head != null){
                head = head.next;
                length++;
            }
            return length;
        }
    }
}
