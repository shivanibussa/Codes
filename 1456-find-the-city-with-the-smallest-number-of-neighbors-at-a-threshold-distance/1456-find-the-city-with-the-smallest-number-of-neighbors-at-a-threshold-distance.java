class Solution 
{
    public int findTheCity(int n, int[][] edges, int threshold) 
    {
        int dist[][] = new int[n][n];
        int res=n+1,ans=n+1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = (int)1e8;
            }
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i] = 0;
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0], v = edges[i][1], wt = edges[i][2];
            dist[v][u] = wt;
            dist[u][v] = wt;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]!=(int)1e8 && dist[k][j]!=(int)1e8)
                    {
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=threshold)
                {
                    c++;
                }
            }
            if(c<=res)
            {
                res = c;
                ans = i;
            }
        }
        return ans;
    }
}