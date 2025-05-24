
class Solution 
{
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) 
    {
        int V = adj.size();
        int dist[] = new int[V];
        Queue<int[]>q = new LinkedList<>();
        
        for(int i=0;i<V;i++)
            dist[i] = (int)1e9;
            
        dist[src]=0;
        q.add(new int[]{src,0});
        
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int popv = pop[0], distx = pop[1];
            
            for(int it:adj.get(popv))
            {
                if(dist[it]>1+distx)
                {
                    dist[it] = 1+distx;
                    q.add(new int[]{it,dist[it]});
                }
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(dist[i]==(int)1e9)
            {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
