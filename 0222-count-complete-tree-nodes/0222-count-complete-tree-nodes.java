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
        if(root.left==null && root.right==null)
            return 1;
        int lh = getLeftHeight(root.left);
        int rh = getRightHeight(root.right);

        if(lh==rh)
            return (int) Math.pow(2,lh+1)-1;

        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int getLeftHeight(TreeNode root)
    {
        TreeNode curr = root;
        int l=0;
        while(curr!=null)
        {
            l++;
            curr=curr.left;
            
        }
        return l;
    }

    public int getRightHeight(TreeNode root)
    {
        TreeNode curr = root;
        int r=0;
        while(curr!=null)
        {
            r++;
            curr = curr.right;
            
        }
        return r;
    }
}