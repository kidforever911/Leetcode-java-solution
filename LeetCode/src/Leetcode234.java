
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

