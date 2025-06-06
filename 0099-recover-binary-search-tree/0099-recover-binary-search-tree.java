class Solution
{
    TreeNode first = null,mid=null,second=null,prev=null;
    public void inorder(TreeNode root) 
    {
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null && prev.val>root.val)
        {
            if(first==null)
            {
                first = prev;
                mid = root;
            }
            else
            {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root)
    {
        prev=null;
        first=null;
        second=null;
        mid=null;
        inorder(root);
        if(first!=null && second!=null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        else if(first!=null && mid!=null)
        {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
}