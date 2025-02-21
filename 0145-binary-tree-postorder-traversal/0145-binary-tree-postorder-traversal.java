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
        if(root==null)
            return al;
        f(root.left,al);
        f(root.right,al);
        al.add(root.val);
        return al;
    }
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> al = new ArrayList<>();
        return f(root,al);
    }
}