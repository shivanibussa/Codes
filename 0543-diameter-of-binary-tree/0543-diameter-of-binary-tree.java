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
    private int maxh = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        height(root);
        return maxh;
        
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        maxh = Math.max(maxh, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}