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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(res,root);
        return res;
    }
    public void inorder(ArrayList<Integer> res, TreeNode root)
    {
        if(root==null)
            return;

        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }
}