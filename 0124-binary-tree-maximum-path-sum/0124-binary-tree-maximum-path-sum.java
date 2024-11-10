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
    int maxSum =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root==null)
        //     return 0;
        heightsum(root, maxSum);
        return maxSum;
        
    }
    private int heightsum(TreeNode root, int maxi)
    {
        if(root==null)
            return 0;
        
        int leftSum = Math.max(0,heightsum(root.left, maxSum));
        int rightSum = Math.max(0,heightsum(root.right, maxSum));
        
        maxSum = Math.max(maxSum, leftSum+rightSum+root.val);
        
        return root.val+Math.max(leftSum, rightSum);
    }
}