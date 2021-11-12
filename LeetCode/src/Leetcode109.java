import javax.swing.tree.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++){
            nums[i] = head.val;
            head = head.next;
        }
        return build(nums, 0, n - 1);
    }
    private TreeNode build(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + right >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n ++;
            temp = temp.next;
        }
        if(n == 1) return new TreeNode(head.val);
        ListNode cur = head;
        //上取整b/a是下取整(b + a - 1) /a，所以n + 1/2上取整是n/2
        for(int i = 0; i < n / 2 - 1; i ++) cur = cur.next;
        TreeNode root = new TreeNode(cur.next.val);
        root.right = sortedListToBST(cur.next.next);
        cur.next = null;
        root.left = sortedListToBST(head);
        return root;

    }
}