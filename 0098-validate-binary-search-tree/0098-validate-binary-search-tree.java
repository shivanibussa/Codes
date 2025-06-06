class Solution 
{
    public boolean isValidBST(TreeNode root) 
    {
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean f(TreeNode root,Long min,Long max)
    {
        if(root==null)
            return true;
        
        if(root.val<=min || root.val>=max)
            return false;
        
        return f(root.left,min,(long)root.val) && f(root.right,(long)root.val,max);
    }
}