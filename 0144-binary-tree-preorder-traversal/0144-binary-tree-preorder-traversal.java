
class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        TreeNode curr = root;
        ArrayList<Integer> res = new ArrayList<>();
        while(curr!=null)
        {
            if(curr.left==null)
            {
                res.add(curr.val);
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
                    res.add(curr.val);
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}