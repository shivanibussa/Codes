class Solution 
{
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        return f(p,q);
    }
    public boolean f(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
            return p==q;
        
        return p.val==q.val && f(p.left,q.left) && f(p.right,q.right);
    }
}