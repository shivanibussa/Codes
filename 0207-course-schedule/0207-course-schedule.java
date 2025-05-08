class Solution 
{
    public boolean canFinish(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[V];
        
        for(int i =0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int pair[]:edges)
        {
            int a = pair[0], b = pair[1];
            adj.get(a).add(b);
            indegree[b]++;
        }
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty())
        {
            int pop = q.poll();
            al.add(pop);
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        return al.size()==V?true:false;
    }
}