class Solution 
{
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)
            return res;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode pop = st.pop();
            res.add(pop.val);
            if(pop.left!=null)
                st.add(pop.left);
            if(pop.right!=null)
                st.add(pop.right);
        }
        Collections.reverse(res);
        return res;
    }
}