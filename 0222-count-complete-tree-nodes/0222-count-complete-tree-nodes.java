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

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left==right)
            return (int)Math.pow(2,left)-1;
        
        else
            return countNodes(root.left)+countNodes(root.right)+1;
    }

    public int getLeftHeight(TreeNode root)
    {
        int count=0;
        while(root!=null)
        {
            count++;
            root = root.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode root)
    {
        int count = 0;
        while(root!=null)
        {
            count++;
            root = root.right;
        }
        return count;
    }
}