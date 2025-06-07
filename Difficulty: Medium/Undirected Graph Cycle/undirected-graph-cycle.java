class Solution 
{
    public boolean isCycle(int V, int[][] edges)
    {
      
        ArrayList<Integer>res = new ArrayList<>();
        
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
                if(dfs(adj,i,-1,visited)==true)
                    return true;
            }
        }
        return false;
        
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj ,int snode,int parent,boolean visited[])
    {
        visited[snode]=true;
        for(int it:adj.get(snode))
        {
            if(visited[it]==false)
            {
                if(dfs(adj,it,snode,visited)==true)
                    return true;
            }
            else if(visited[it]==true && it!=parent)
            {
                return true;
            }
        }
        return false;
    }
}