import java.util.PriorityQueue;

public class Leetcode23 {
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

        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                //用heap(堆)这种数据结构，也就是 java 里面的 PriorityQueue
                PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        return a.val-b.val;
                    }
                });
                ListNode ret = null, cur = null;
                for(ListNode node: lists) {
                    if(null != node) {
                        pq.add(node);
                    }
                }
                while(!pq.isEmpty()) {
                    ListNode node = pq.poll();
                    if(null == ret) {
                        ret = cur = node;
                    }
                    else {
                        cur = cur.next = node;
                    }
                    if(null != node.next) {
                        pq.add(node.next);
                    }
                }
                return ret;
            }
        }

        class Solution {
            public ListNode mergeKLists(ListNode[] lists){
                if(lists.length == 0)
                    return null;
                if(lists.length == 1)
                    return lists[0];
                if(lists.length == 2){
                    return mergeTwoLists(lists[0],lists[1]);
                }

                int mid = lists.length/2;
                ListNode[] l1 = new ListNode[mid];
                for(int i = 0; i < mid; i++){
                    l1[i] = lists[i];
                }

                ListNode[] l2 = new ListNode[lists.length-mid];
                for(int i = mid,j=0; i < lists.length; i++,j++){
                    l2[j] = lists[i];
                }

                return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));

            }
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                if (l1 == null) return l2;
                if (l2 == null) return l1;

                ListNode head = null;
                if (l1.val <= l2.val){
                    head = l1;
                    head.next = mergeTwoLists(l1.next, l2);
                } else {
                    head = l2;
                    head.next = mergeTwoLists(l1, l2.next);
                }
                return head;
            }
        }
}
