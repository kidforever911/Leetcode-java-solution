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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;
        return dummy.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 注意点：当有链表为空时，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}

//原地算法
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1.next != null && cur2 != null) {
            while(cur1.next != null && cur1.next.val <= cur2.val) {
                cur1 = cur1.next;
            }
            ListNode next = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur2 = next;
        }
        if(cur1.next == null) cur1.next = cur2;
        return list1;
    }
}