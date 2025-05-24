class Solution 
{
    public boolean isBipartite(int[][] graph) 
    {
        int V = graph.length;
        int color[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            color[i] = -1;
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(i,color,graph,0)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int color[],int graph[][],int col)
    {
        color[node] = col;
            for(int it:graph[node])
            {
                if(color[it]==-1)
                {
                    if(dfs(it,color,graph,1-col)==false)
                        return false;
                }
                else if(color[it]==color[node])
                {
                    return false;
                }
            }
        return true;
    }
}