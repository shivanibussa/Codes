class Solution 
{
    public boolean isCyclic(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int pair[]:edges)
        {
            int x = pair[0];
            int y = pair[1];
            adj.get(x).add(y);
        }
        
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,adj,visited,pathvisited)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int node,List<List<Integer>> adj,int visited[],int pathvisited[])
    {
        visited[node]=1;
        pathvisited[node]=1;
        
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                if(dfs(it,adj,visited,pathvisited)==true)
                    return true;
            }
            else if(visited[it]==1 && pathvisited[it]==1)
            {
                return true;
            }
        }
        pathvisited[node]=0;
        return false;
    }
}