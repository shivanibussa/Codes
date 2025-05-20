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
    public boolean checkTree(TreeNode root) 
    {
        return f(root)==root.val;
    }
    public int f(TreeNode root)
    {
        if(root.left==null && root.right==null)
            return root.val;

        int left = f(root.left);
        int right = f(root.right);
        return left+right;
    }
}