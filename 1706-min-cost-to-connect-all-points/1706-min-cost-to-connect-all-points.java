class Solution 
{
    public int minCostConnectPoints(int[][] points) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        int vis[] = new int[points.length];
        int sum=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<points.length;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<points.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                if(i!=j)
                {
                    int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    adj.get(i).add(new int[]{j,dist});
                }
            }
        }

        pq.offer(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int pops[] = pq.poll();
            int weight = pops[0];
            int node = pops[1];

            if(vis[node]==1)
                continue;
            
            vis[node]=1;
            sum+=weight;

            for(int adjn[]:adj.get(node))
            {
                int vertex = adjn[0];
                int wt = adjn[1];
                if(vis[vertex]==0)
                {
                    pq.offer(new int[]{wt,vertex});
                }
                
            }
        }
        return sum;
    }
}