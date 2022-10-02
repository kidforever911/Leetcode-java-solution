class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = temp;
        return head;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oh = head, ot = oh;
        ListNode eh = head.next, et = eh;
        for(ListNode p = head.next.next; p != null; ) {
            ot.next = p;
            ot = ot.next;
            p = p.next;
            if(p != null) {
                et.next = p;
                et = et.next;
                p = p.next;
            }
        }
        et.next = null;
        ot.next = eh;
        return oh;
    }
}

