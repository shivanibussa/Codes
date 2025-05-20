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
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    TreeNode mid;
    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        if(prev != null && root.val<prev.val)
        {
            if(first==null)
            {
                first = prev;
                mid = root;
            }
            else
            {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) 
    {
        prev = null;first=null;second=null;mid=null;
        inorder(root);
        if(first!=null && second!=null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        else if(first!=null && mid!=null)
        {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
        
    }
}