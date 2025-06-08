class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        int dist[] = new int[n];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            dist[i]=(int)1e9;
        }
        for(int i=0;i<flights.length;i++)
        {
            int a = flights[i][0], b = flights[i][1], c=flights[i][2];
            adj.get(a).add(new int[]{b,c});
        }
        q.offer(new int[]{0,0,src});
        dist[src]=0;

        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int stops = pop[0];
            int d = pop[1];
            int v = pop[2];
            if(stops>k)
                break;
            for(int it[]:adj.get(v))
            {
                int nv = it[0];
                int nw = it[1];

                if(dist[nv]>nw+d)
                {
                    dist[nv]=nw+d;
                    q.offer(new int[]{stops+1,dist[nv],nv});
                }
            }
        }
        return (dist[dst]==(int)1e9 ? -1:dist[dst]);

    }
}