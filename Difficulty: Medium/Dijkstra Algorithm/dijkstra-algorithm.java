class Solution 
{
    public int[] dijkstra(int V, int[][] edges, int src) 
    {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0], v = edges[i][1], wt = edges[i][2];
            adj.get(u).add(new int[]{v,wt});
        }
        dist[src]=0;
        pq.add(new int[]{0,src});
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int wt = pop[0], vertex = pop[1];
            for(int it[]:adj.get(vertex))
            {
                int nv = it[0], d = it[1];
                if(dist[vertex]+d<dist[nv])
                {
                    dist[nv] = dist[vertex]+d;
                    pq.offer(new int[]{dist[nv],nv});
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