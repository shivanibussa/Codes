class Solution 
{
    public void parentsFeed(HashMap<TreeNode,TreeNode> tm,TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // HashMap<Tr,Integer>tm = new HashMap<>();
        while(!q.isEmpty())
        {
            TreeNode pop = q.poll();
            if(pop.left!=null)
            {
                q.add(pop.left);
                tm.put(pop.left,pop);
            }   
            if(pop.right!=null)
            {
                q.add(pop.right);
                tm.put(pop.right,pop);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parentsFeed(parents,root);
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        q.add(target);
        int steps=0;
        while(!q.isEmpty())
        {
            if(steps==k)
                break;
            steps++;
            int s = q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode pop = q.poll();
                visited.put(pop,true);
                if(pop.left!=null && visited.get(pop.left)==null)
                {
                    q.add(pop.left);
                    visited.put(pop.left,true);
                }
                if(pop.right!=null && visited.get(pop.right)==null)
                {
                    q.add(pop.right);
                    visited.put(pop.right,true);
                }
                if(parents.get(pop)!=null && visited.get(parents.get(pop))==null)
                {
                    q.add(parents.get(pop));
                    visited.put(parents.get(pop),true);
                }
            }
        }
        while(!q.isEmpty())
        {
            res.add(q.poll().val);
        }
        return res;
    }
}