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
    public TreeNode insertIntoBST(TreeNode curr, int val) 
    {
        TreeNode root = curr;
        TreeNode prev = null;
        if(root==null)
                return new TreeNode(val);
        while(root!=null)
        {
            prev = root;
            if(root.val>val)
            {
                root=root.left;
            }
            else
            {
                root=root.right;
            }
        }
        System.out.println(prev.val);
        if(prev.val>val)
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);

        return curr;
    }
}