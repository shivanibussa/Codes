class Solution 
{
    public boolean isCyclic(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,visited,pathvisited,adj)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int node,int visited[],int pathvisited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=1;
        pathvisited[node]=1;
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                if(dfs(it,visited,pathvisited,adj)==true)
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