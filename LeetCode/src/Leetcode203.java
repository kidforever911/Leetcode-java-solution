public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //递归：
    //When the input node is an empty node, then there is nothing to delete, so we just return a null node back. (That's the first line)
    //
    //When the head of the input node is the target we want to delete, we just return head.next instead of head to skip it. (That's the third line), else we will return head.
    //
    //We apply the same thing to every other node until it reaches null. (That's the second line).
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val? head.next : head;
    }
}
