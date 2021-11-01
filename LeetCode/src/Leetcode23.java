import java.util.PriorityQueue;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            //用heap(堆)这种数据结构，也就是 java 里面的 PriorityQueue
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    //升序排列
                    return a.val - b.val;
                }
            });
            ListNode ret = null, cur = null;
            for (ListNode node : lists) {
                if (null != node) {
                    pq.add(node);
                }
            }
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                if (null == ret) {
                    ret = cur = node;
                } else {
                    cur = cur.next = node;
                }
                if (null != node.next) {
                    pq.add(node.next);
                }
            }
            return ret;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;
            if (lists.length == 1)
                return lists[0];
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }

            int mid = lists.length / 2;
            ListNode[] l1 = new ListNode[mid];
            for (int i = 0; i < mid; i++) {
                l1[i] = lists[i];
            }

            ListNode[] l2 = new ListNode[lists.length - mid];
            for (int i = mid, j = 0; i < lists.length; i++, j++) {
                l2[j] = lists[i];
            }

            return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));

        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode head = null;
            if (l1.val <= l2.val) {
                head = l1;
                head.next = mergeTwoLists(l1.next, l2);
            } else {
                head = l2;
                head.next = mergeTwoLists(l1, l2.next);
            }
            return head;
        }
    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            });
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (ListNode node : lists) {
                if (node != null)
                    heap.add(node);
            }
            while (!heap.isEmpty()) {
                ListNode temp = heap.peek();
                heap.poll();
                tail.next = temp;
                tail = tail.next;
                if (temp.next != null) heap.add(temp.next);
            }
            return dummy.next;
        }
    }
