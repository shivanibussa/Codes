class Solution 
{
    public int[] dijkstra(int V, int[][] edges, int src) 
    {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[V];
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0],b=edges[i][1],c=edges[i][2];
            adj.get(a).add(new int[]{b,c});
        }
        
        pq.offer(new int[]{0,src});
        dist[src]=0;
        
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int wt = pop[0],node = pop[1];
            
            for(int it[]:adj.get(node))
            {
                int itv = it[0];
                int itw = it[1];
                
                if(dist[itv]>itw+wt)
                {
                    dist[itv]=itw+wt;
                    pq.add(new int[]{dist[itv],itv});
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