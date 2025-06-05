class Solution 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode pop = st.pop();
            res.add(pop.val);
            if(pop.right!=null)
                st.add(pop.right);
            if(pop.left!=null)
                st.add(pop.left);
        }
        return res;
    }
    
}