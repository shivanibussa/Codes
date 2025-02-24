/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        TreeNode curr = root;
        while(curr!=null)
        {
            int value = curr.val;
            if(p.val<value && q.val<value)
                curr = curr.left;
            else if(p.val>value && q.val>value)
                curr = curr.right;
            else
                return curr;

        }
        return curr;
    }
}