class Solution 
{
    public boolean isBalanced(TreeNode root) 
    {
        if(root==null || (root.left == null && root.right==null))
            return true;
        return f(root)==-1 ? false:true;   
    }
    public int f(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int lh = f(root.left);
        if(lh==-1)
            return -1;
        int rh = f(root.right);
        if(rh==-1)
            return -1;
        if(Math.abs(lh-rh)>1)
            return -1;
        return 1+Math.max(lh,rh); 
    }
}