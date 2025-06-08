class Solution {
    public int countPaths(int V, int[][] edges) {
        PriorityQueue<long[]>pq = new PriorityQueue<>((a,b)->(Long.compare(a[0],b[0])));
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        long dist[] = new long[V];
        int ways[] = new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0],b=edges[i][1],c=edges[i][2];
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }
        
        pq.offer(new long[]{0,0});
        dist[0]=0;
        ways[0]=1;
        while(!pq.isEmpty())
        {
            long pop[] = pq.poll();
            long wt = pop[0];
            int node = (int)pop[1];
            
            for(int it[]:adj.get(node))
            {
                int itv = it[0];
                int itw = it[1];
                
                if(dist[itv]>itw+wt)
                {
                    dist[itv] = itw+wt;
                    ways[itv] = ways[(int)node];
                    pq.add(new long[]{dist[itv],itv});
                }
                else if(dist[itv]==itw+wt)
                {
                    ways[itv] = (ways[itv] + ways[node])%1000000007;
                }
            }
        }
        return ways[V-1];
    }
}