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
class Solution 
{
    private int maxS = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        f(root);
        return maxS;
    }
    public int f(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int lh = Math.max(0,f(root.left));
        int rh = Math.max(0,f(root.right));
        maxS = Math.max(maxS,root.val+lh+rh);
        return root.val+Math.max(lh,rh);
    }
}