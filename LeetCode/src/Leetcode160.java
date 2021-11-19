/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            if(tempA != null) tempA = tempA.next;
            else tempA = headB;
            if(tempB != null) tempB = tempB.next;
            else tempB = headA;
        }
        return tempA;
    }
}