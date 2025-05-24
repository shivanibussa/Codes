class Solution 
{
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int V = graph.length;
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        int check[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==0)
            {
                dfs(graph,visited,pathvisited,check,i);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(check[i]==1)
                res.add(i);
        }
        return res;
    }
    public boolean dfs(int graph[][],int vis[],int pathvis[],int check[],int node)
    {
        vis[node]=1;
        pathvis[node]=1;

        for(int it:graph[node])
        {
            if(vis[it]==0)
            {
                if(dfs(graph,vis,pathvis,check,it)==true)
                    return true;
            }
            else if(vis[it]==1 && pathvis[it]==1)
            {
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}