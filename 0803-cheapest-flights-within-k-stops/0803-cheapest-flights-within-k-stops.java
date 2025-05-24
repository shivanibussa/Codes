class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        int V = flights.length;
        int dist[] = new int[n];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }
        for(int i=0;i<flights.length;i++)
        {
            int a = flights[i][0];
            int b = flights[i][1];
            int c = flights[i][2];
            adj.get(a).add(new int[]{b,c});
        }
        dist[src]=0;
        q.add(new int[]{0,0,src});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int stops = pop[0], wt = pop[1],ver = pop[2];
            if(stops>k)
                continue;     
            for(int it[]:adj.get(ver))
            {
                int nv = it[0];
                int nw = it[1];
                if(dist[nv]>wt+nw)
                {
                    dist[nv] = wt+nw;
                    q.offer(new int[]{stops+1,dist[nv],nv});
                }
            }
        }
        if(dist[dst]==(int)1e9)
            return -1;
        return dist[dst];
    }
}