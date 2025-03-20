class Solution 
{
    private int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n];
        int tin[] = new int[n];
        int low[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,tin,low,adj,bridges);
        return bridges;
    }
    public void dfs(int node,int parent,int [] vis, int[] tin,int[] low,ArrayList<ArrayList<Integer>> adj,List<List<Integer>> bridges)
    {
        vis[node]=1;
        tin[node]=timer;low[node]=timer;
        timer++;

        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(vis[it]==0)
            {
                dfs(it,node,vis,tin,low,adj,bridges);
                low[node] = Math.min(low[node],low[it]);
                if(low[it]>tin[node])
                    bridges.add(Arrays.asList(it,node));
                    
            }
            else
            {
                low[node] = Math.min(low[node],low[it]);
            }
        }
    }
}