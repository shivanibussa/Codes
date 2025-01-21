class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        int dist[] = new int[n+1];
        int maxt = 0;
        for(int i=1;i<n+1;i++)
        {
            dist[i] = (int)(1e8);
        }
        dist[k]=0;
        for(int j=0;j<n-1;j++)
        {
            for(int i=0;i<times.length;i++)
            {
                int u = times[i][0];
                int v = times[i][1];
                int wt = times[i][2];

                if(dist[u]!=(int)(1e8) && dist[u]+wt<dist[v])
                {
                    dist[v] = dist[u]+wt;
                }
            }
        }
        for(int i=1;i<n+1;i++)
        {
            if(dist[i]==(int)(1e8))
                return -1;
            maxt = Math.max(maxt,dist[i]);
        }
        
        return maxt;
    }
}