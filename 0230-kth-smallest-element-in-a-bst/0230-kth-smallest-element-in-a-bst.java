class Solution 
{
    public int kthSmallest(TreeNode root, int k) 
    {
        TreeNode curr = root;
        int c=0;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                c++;
                if(c==k)
                    return curr.val;
                curr = curr.right;
            }
            else
            {
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    c++;
                    if(c==k)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }    
        return -1;
    }
}