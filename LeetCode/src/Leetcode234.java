
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode cutNode = cut(head, slow);
        return isEqual(cutNode, reverse(slow));
    }

    private ListNode cut(ListNode head, ListNode slow) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
        return dummy.next;
    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = new ListNode();
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private boolean isEqual(ListNode cutNode, ListNode reverseNode) {
        while (cutNode != null && reverseNode != null) {
            if (cutNode.val != reverseNode.val) {
                return false;

            }
            cutNode = cutNode.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

}

class Solution {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            n ++;
        }
        ListNode tail = head;
        for(int i = 0; i < n / 2; i ++) {
            tail = tail.next;
        }
        ListNode first = reverse(head, tail);
        ListNode second = new ListNode();
        if(n % 2 == 1) second = tail.next;
        else second = tail;
        while(first != null && second != null) {
            if(first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while(head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

