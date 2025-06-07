
class Solution 
{
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) 
    {
        int V = adj.size();
        int dist[] = new int[V];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<V;i++)
            dist[i] = (int)1e9;
            
        dist[src]=0;
        
        q.add(new int[]{0,src});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int node = pop[1], wt = pop[0];
            
            for(int it:adj.get(node))
            {
                int itv = it;
        
                if(dist[itv]>1+wt)
                {
                    dist[itv] = 1+wt;
                    q.add(new int[]{dist[itv],itv});
                }
            }
            
        }
         for(int i=0;i<V;i++)
        {
            if(dist[i]==(int)1e9)
                dist[i]=-1;
        }
        return dist;
        
    }
}
