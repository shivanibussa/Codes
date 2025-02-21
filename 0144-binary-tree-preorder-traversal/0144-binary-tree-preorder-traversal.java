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
    public List<Integer> f(TreeNode root,List<Integer> al)
    {
        al.add(root.val);
        if(root.left!=null)
            f(root.left,al);
        if(root.right!=null)
            f(root.right,al);
        if(root.left==null && root.right==null)
            return al;
        return al;
    }
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> al = new ArrayList<>();
        if(root==null)
            return al;
        return f(root,al);
        // return al;
    }
}