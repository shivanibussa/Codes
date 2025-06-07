class Solution 
{
    public boolean isBipartite(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int color[] = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
            color[i]=-1;
        }
        for(int pair[]:edges)
        {
            int x = pair[0];
            int y = pair[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(bfs(i,color,adj)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean bfs(int node,int color[],List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int it:adj.get(pop))
            {
                if(color[it]==-1)
                {
                    q.add(it);
                    color[it]=1-color[pop];
                }
                else if(color[it]==color[pop])
                {
                    return false;
                }
            }
        }
        return true;
    }
}