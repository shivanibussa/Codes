class Solution 
{
    public boolean isSymmetric(TreeNode root) 
    {
        return f(root.left,root.right);
    }
    public boolean f(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
            return p==q;
        return p.val==q.val && f(p.left,q.right) && f(p.right,q.left);
    }
}