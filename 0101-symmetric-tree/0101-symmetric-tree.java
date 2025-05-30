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
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)
            return true;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty())
        {
            TreeNode pop1 = q.poll();
            TreeNode pop2 = q.poll();

            if(pop1==null && pop2==null)
                continue;

            if(pop1==null || pop2==null)
                return false;

            if(pop1.val!=pop2.val)
                return false;

            q.add(pop1.left);
            q.add(pop2.right);
            q.add(pop2.left);
            q.add(pop1.right);
        }
        return f(root.left,root.right);
    }
    public boolean f(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
            return p==q;

        return (p.val==q.val) && f(p.left,q.right) && f(p.right,q.left);
    }
}