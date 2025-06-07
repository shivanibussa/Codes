class Solution 
{
    public List<Integer> eventualSafeNodes(int[][] adj) 
    {
        int V = adj.length;
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        int check[] = new int[V];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,adj,visited,pathvisited,check);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(check[i]==1)
                res.add(i);
        }
        return res;
    }
    public boolean dfs(int node,int[][] adj,int visited[],int pathvisited[],int check[])
    {
        visited[node]=1;
        pathvisited[node]=1;
        for(int it:adj[node])
        {
            if(visited[it]==0)
            {
                if(dfs(it,adj,visited,pathvisited,check)==true)
                    return true;
            }
            else if(visited[it]==1 && pathvisited[it]==1)
            {
                return true;
            }
        }
        pathvisited[node]=0;
        check[node]=1;
        return false;
    }
}