class Solution 
{
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        boolean visited[] = new boolean[n];
        int tin[] = new int[n];
        int low[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it:connections)
        {
            int u = it.get(0), v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0,-1,adj,visited,tin,low,bridges);
        return bridges;

    }
    public void dfs(int node, int parent,List<List<Integer>> adj, boolean visited[],int tin[],int low[],List<List<Integer>> bridges)
    {
        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;

        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(!visited[it])
            {
                dfs(it,node,adj,visited,tin,low,bridges);
                low[node] = Math.min(low[node],low[it]);
                if(low[it]>tin[node])
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(it);temp.add(node);
                    bridges.add(temp);
                }   
            }
            else
            {
                low[node] = Math.min(low[node],low[it]);
            }
        }
    }
}