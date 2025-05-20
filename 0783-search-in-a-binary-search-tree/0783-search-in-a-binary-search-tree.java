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
    public TreeNode searchBST(TreeNode root, int val) 
    {
        return f(root,val);
    }
    public TreeNode f(TreeNode root,int val)
    {
        if(root==null)
            return null;
        if(root.val==val)
            return root;

        return root.val > val ? f(root.left,val):f(root.right,val);
    }
}