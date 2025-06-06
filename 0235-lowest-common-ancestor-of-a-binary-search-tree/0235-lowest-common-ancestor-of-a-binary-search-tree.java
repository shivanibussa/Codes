class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        TreeNode curr = root;
        while(curr!=null)
        {
            if(curr.val<p.val && curr.val<q.val)
                curr = curr.right;
            else if(curr.val>p.val && curr.val>q.val)
                curr = curr.left;
            else
                return curr;
        }
        return null;
    }
    public TreeNode f(TreeNode root,TreeNode p,TreeNode q)
    {
        if(p.val>root.val && q.val>root.val)
            root = root.right;
        else if(p.val<root.val && q.val<root.val)
            root = root.left;

            return root;
    }

}