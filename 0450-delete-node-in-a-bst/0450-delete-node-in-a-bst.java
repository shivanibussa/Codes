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
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        TreeNode curr = root;
        if(root==null)
            return null;
        if(root.val==key)
            return helper(root);
        while(curr!=null)
        {
            if(curr.val>key)
            {
                if(curr.left!=null && curr.left.val==key)
                    curr.left = helper(curr.left);
                else
                    curr = curr.left;
            }
            else
            {
                if(curr.right!=null && curr.right.val==key)
                    curr.right = helper(curr.right);
                else
                    curr = curr.right;
            }
        }
        return root;
    }

    public TreeNode helper(TreeNode node)
    {
        if(node.left==null)
            return node.right;
        else if(node.right==null)
            return node.left;
        else
        {
            TreeNode rightbranch = node.right;
            TreeNode lastchild = lastchild(node.left);
            lastchild.right = rightbranch;
            return node.left;
        }
    }
    public TreeNode lastchild(TreeNode node)
    {
        while(node.right!=null)
        {
            node = node.right;
        }
        return node;
    }
}