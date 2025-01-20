class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[] = new int[n];

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        pq.offer(new int[]{0,0,src});
        dist[src]=0;

        for(int i=0;i<flights.length;i++)
        {
            int u = flights[i][0];
            int v = flights[i][1];
            int t = flights[i][2];

            adj.get(u).add(new int[]{v,t});
        }
        
        while(!pq.isEmpty())
        {
            int pops[] = pq.poll();
            int stops = pops[0];
            int time = pops[1];
            int vertex = pops[2];

            if(stops>k)
                continue;
            for(int[] neigh:adj.get(vertex))
            {
                int neighv = neigh[0];
                int neight = neigh[1];

                if(stops<=k && dist[neighv]>time+neight)
                {
                    dist[neighv] = time+neight;
                    pq.offer(new int[]{stops+1,dist[neighv],neighv});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        else
            return dist[dst];
    }
}