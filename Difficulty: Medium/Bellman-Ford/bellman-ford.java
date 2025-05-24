// User function Template for Java

class Solution 
{
    public int[] bellmanFord(int V, int[][] edges, int src) 
    {
        int dist[] = new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i] = (int)1e8;
        }
        dist[src]=0;
        for(int i=0;i<V-1;i++)
        {
            for(int j=0;j<edges.length;j++)
            {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(dist[u]!=(int)1e8 && w+dist[u]<dist[v])
                {
                    dist[v] = w+dist[u];
                }
            }
        }
        for(int j=0;j<edges.length;j++)
        {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            
            if(dist[u]!=(int)1e8 && w+dist[u]<dist[v])
            {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
