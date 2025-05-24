class Solution 
{
    public int countPaths(int n, int[][] edges) 
    {
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        long dist[] = new long [n];
        int ways[] = new int[n];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }

        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];

            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }

        dist[0] = 0;
        q.offer(new long[]{0,0});
        ways[0] = 1;

        while(!q.isEmpty())
        {
            long pop[] = q.poll();
            long w = pop[0]; 
            int ver = (int) pop[1];
            if(w>dist[ver])
                continue;
            for(int it[]:adj.get(ver))
            {
                int nv = it[0];
                int neiW = it[1];

                if(dist[nv]>neiW+w)
                {
                    dist[nv] = neiW+w;
                    ways[nv] = ways[(int)ver];
                    q.add(new long[]{dist[nv],nv});
                }
                else if(dist[nv]==neiW+w)
                {
                    ways[nv]=(ways[nv]+ways[ver])%1000000007;
                }
            }
        }
        return ways[n-1];
    }
}