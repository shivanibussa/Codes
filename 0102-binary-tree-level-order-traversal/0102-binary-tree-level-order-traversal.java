class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                temp.add(pop.val);
                if(pop.left!=null)
                    q.add(pop.left);
                if(pop.right!=null)
                    q.add(pop.right);
            }
            res.add(temp);
        }
        return res;
    }
}