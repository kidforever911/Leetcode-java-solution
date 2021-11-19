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
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        int n = 0;
        for(ListNode p = head; p != null; p = p.next) n ++;
        for(int i = 1; i < n; i *= 2){
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            for(int j = 1; j <= n; j += 2 * i){
                ListNode p = head, q = p;
                for(int k = 0; k < i && q != null; k ++) q = q.next;
                ListNode o = q;
                for(int k = 0;k < i && o != null; k ++) o = o.next;

                int l = 0, r = 0;
                while(l < i && r < i && p != null && q != null){
                    if(p.val < q.val){
                        cur = cur.next = p;
                        p = p.next;
                        l ++;
                    }else{
                        cur = cur.next = q;
                        q = q.next;
                        r ++;
                    }
                }
                while(l < i && p != null){
                    cur = cur.next = p;
                    p = p.next;
                    l ++;
                }
                while(r < i && q != null){
                    cur = cur.next = q;
                    q = q.next;
                    r ++;
                }
                head = o;
            }
            cur.next = null;
            head = dummy.next;
        }
        return head;
    }
}