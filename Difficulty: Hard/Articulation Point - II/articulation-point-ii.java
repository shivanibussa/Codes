class Solution 
{
    private static int timer = 0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int tin[] = new int[V];
        int low[] = new int[V];
        int mark[] = new int[V];
        int visited[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++)
            if(visited[i]==0)
                dfs(i,-1,tin,low,mark,visited,adj);
        for(int i=0;i<V;i++)
        {
            if(mark[i]==1)
            {
                res.add(i);
            }
        }
        if(res.size()==0)
            res.add(-1);
        return res;
    }
    public static void dfs(int node,int parent,int tin[],int low[],int mark[],int visited[],List<List<Integer>> adj)
    {
        visited[node]=1;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        int child=0;
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                dfs(it,node,tin,low,mark,visited,adj);
                low[node] = Math.min(low[node],low[it]);
                if(low[it]>=tin[node] && parent!=-1)
                {
                    mark[node]=1; 
                }
                child++;
            }
            else
            {
                low[node] = Math.min(low[node],tin[it]);
            }
            
        }
        if(child>1 && parent==-1)
                mark[node]=1;
    }
}