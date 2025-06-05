class Solution 
{
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(true)
        {
            if(root!=null)
            {
                st.add(root);
                root = root.left;
            }
            else
            {
                if(st.isEmpty())
                    break;

                TreeNode pop = st.pop();
                res.add(pop.val);
                if(pop.right!=null)
                    root = pop.right;
            }
        }
        return res;
    }
}