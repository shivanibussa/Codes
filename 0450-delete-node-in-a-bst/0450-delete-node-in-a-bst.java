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
        while(root!=null)
        {
            if(root.val>key)
            {
                if(root.left!=null && root.left.val == key)
                    root.left = helper(root.left);
                else
                    root = root.left;
            }
            else
            {
                if(root.right!=null && root.right.val == key)
                    root.right = helper(root.right);
                else
                    root = root.right;
            }
            
        }
        return curr;
    }
        public  TreeNode helper(TreeNode node)
        {
            if(node.left==null)
                return node.right;
            else if(node.right==null)
                return node.left;
            else
            {
                TreeNode rightChild = node.right;
                TreeNode lastChild = findLast(node.left);
                lastChild.right = rightChild;
                return node.left;
            }
        }
        public TreeNode findLast(TreeNode root)
        {
            while(root.right!=null)
                root= root.right;
            return root;
        }
    
}