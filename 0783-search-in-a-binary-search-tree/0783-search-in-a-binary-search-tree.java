class Solution 
{
    public TreeNode searchBST(TreeNode root, int val) 
    {
        TreeNode curr = root;
        while(curr!=null && curr.val!=val)
        {
            curr = curr.val>val ? curr.left : curr.right;
        }
        return curr;
    }
}