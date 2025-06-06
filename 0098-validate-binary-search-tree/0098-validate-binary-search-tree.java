class Solution 
{
    public boolean isValidBST(TreeNode root) 
    {
        TreeNode curr = root;
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean f(TreeNode curr,long min, long max)
    {
        if(curr==null)
            return true;
        if(curr.val <= min || curr.val >= max)
            return false;
        
        return f(curr.left,min,curr.val) && f(curr.right,curr.val,max);
    }
}