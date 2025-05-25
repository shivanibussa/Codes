class Solution 
{
    private static int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        int tin[] = new int[n];
        int low[] = new int[n];
        int visited[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(tin,low,adj,visited,bridges,0,-1);
        return bridges;
    }
    public void dfs(int tin[],int low[],ArrayList<ArrayList<Integer>> adj,int visited[],List<List<Integer>> bridges,int node,int parent)
    {
        visited[node]=1;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;

            if(visited[it]==0)
            {
                dfs(tin,low,adj,visited,bridges,it,node);
                low[node] = Math.min(low[it],low[node]);
                if(low[it]>tin[node])
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(it);temp.add(node);
                    bridges.add(temp);
                }
            }
            else
            {
                low[node] = Math.min(low[it],low[node]);
            }
        }
    }
}