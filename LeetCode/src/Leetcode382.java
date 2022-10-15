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
    private ListNode h;
    private Random rand;
    public Solution(ListNode head) {
        h = head;
        rand = new Random();
    }

    public int getRandom() {
        int c = -1, n = 0;
        for(ListNode p = h; p != null; p = p.next) {
            n ++;
            if(rand.nextInt(n) == 0) c = p.val;
        }
        return c;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */