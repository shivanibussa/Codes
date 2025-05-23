class Solution 
{
    public boolean isCycle(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(dfs(adj,visited,i,-1))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int node,int parent)
    {
        visited[node] = true;
        for(int it:adj.get(node))
        {
            if(visited[it]==false)
            {
                if(dfs(adj,visited,it,node)==true)
                    return true;
            }
            else if(it!=parent)
            {
                return true;
            }
        }
        return false;
    }
}