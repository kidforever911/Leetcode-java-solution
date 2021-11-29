/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] printListReversingly(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count ++;
        }
        int[] result = new int[count];
        for(int i = 0; i < count && pre != null; i ++){
            result[i] = pre.val;
            pre = pre.next;
        }
        return result;
    }
}

class Solution {
    public int[] printListReversingly(ListNode head) {
        Stack<Integer> record = new Stack<>();
        int count = 0;
        while(head != null){
            record.push(head.val);
            head = head.next;
            count ++;
        }
        int[] result = new int[count];
        for(int i = 0; i < count; i ++){
            result[i] = record.pop();
        }
        return result;
    }
}