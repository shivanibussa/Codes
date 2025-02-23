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
    public int leftHeight(TreeNode node)
    {
        if(node==null)
            return 0;
        int c=0;
        while(node!=null)
        {
            c++;
            node = node.left;
        }
        return c;
    }
    public int rightHeight(TreeNode node)
    {
        if(node==null)
            return 0;
        int c=0;
        while(node!=null)
        {
            c++;
            node = node.right;
        }
        return c;
    }
    public int countNodes(TreeNode root) 
    {
        if(root==null)
            return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh==rh)
            return  (int)Math.pow(2,lh)-1;
        return 1+ countNodes(root.left)+countNodes(root.right);
    }
}