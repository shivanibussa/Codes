class Solution 
{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
        int dist[][] = new int[n][n];
        int res = n,vertex=-1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j] = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i]=0;
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                {
                    c++;
                }
            }
            if(c<=res)
            {
                res = c;
                vertex=i;
            }
        }
        return vertex;
    }
}