/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

作者：kidforever911
        链接：https://www.acwing.com/activity/content/code/content/2137189/
        来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。