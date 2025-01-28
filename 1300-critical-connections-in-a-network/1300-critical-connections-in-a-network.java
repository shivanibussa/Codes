class Solution 
{
    private static int timer=1;
    public void dfs(int node, int parent, int visited[], List<List<Integer>> adj,int low[], int tin[],List<List<Integer>> bridges)
    {
        visited[node]=1;
        tin[node] = low[node] = timer;
        timer+=1;
        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(visited[it]==0)
            {
                dfs(it,node,visited,adj,low,tin,bridges);
                low[node] = Math.min(low[node],low[it]);

                if(low[it]>tin[node])
                {
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else
            {
                low[node] = Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        int visited[] = new int[n];
        int tin[] = new int[n];
        int low[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0,-1,visited,adj,low,tin,bridges);
        return bridges;
    }
}