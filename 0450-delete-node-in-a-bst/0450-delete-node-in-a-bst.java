class Solution
{
    public TreeNode deleteNode(TreeNode root, int key)
    {
        TreeNode curr = root;
        if(root==null)
            return null;
        if(root.val==key)
            return helper(root);
        while(curr!=null)
        {
            if(curr.val>key)
            {
                if(curr.left!=null && curr.left.val==key)
                    curr.left  = helper(curr.left);
                else
                    curr = curr.left;
            }
            else
            {
                if(curr.right!=null && curr.right.val==key)
                    curr.right = helper(curr.right);
                else
                    curr = curr.right;
            }
        }    
        return root;
    }

    public TreeNode helper(TreeNode curr)
    {
        if(curr.left==null)
            return curr.right;
        else if(curr.right==null)
            return curr.left;
        else
        {
            TreeNode rightchild = curr.right;
            TreeNode lastchild = getLC(curr.left);
            lastchild.right = rightchild;
            return curr.left;
        }
    }

    public TreeNode getLC(TreeNode root)
    {
        TreeNode curr = root;
        while(curr.right!=null)
        {
            curr = curr.right;
        }
        return curr;
    }
}