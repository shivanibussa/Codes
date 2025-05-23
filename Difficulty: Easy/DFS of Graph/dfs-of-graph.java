class Solution 
{
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        int visited[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(adj,visited,res,0);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int visited[],ArrayList<Integer> res, int node)
    {
        visited[node]=1;
        res.add(node);
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                dfs(adj,visited,res,it);
            }
        }
    }
}