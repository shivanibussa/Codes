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
    public int countNodes(TreeNode root) 
    {
        if(root==null)
            return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        
        if(leftHeight==rightHeight)
            return (int)Math.pow(2,leftHeight)-1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);
        
    }
    
    public int getLeftHeight(TreeNode root)
    {
        int lh=0;
        if(root==null)
            return 0;
        while(root!=null)
        {
            lh++;
            root=root.left;
        }
        return lh;
    }
     public int getRightHeight(TreeNode root)
    {
         int rh=0;
        if(root==null)
            return 0;
        while(root!=null)
        {
            rh++;
            root=root.right;
        }
        return rh;
    }
}