import javax.swing.tree.TreeNode;

public class Leetcode108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length == 0) return null;
            TreeNode result = builder(nums, 0, nums.length - 1);
            return result;
        }
        private TreeNode builder(int[] nums, int left, int right){
            if(left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = builder(nums, left, mid - 1);
            node.right = builder(nums, mid + 1, right);
            return node;
        }
    }
}
