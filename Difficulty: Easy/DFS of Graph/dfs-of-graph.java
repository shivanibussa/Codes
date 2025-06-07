class Solution 
{
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        boolean visited[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res,adj,visited,0);
        return res;
    }
    public void dfs(ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj,boolean visited[],int node)
    {
        visited[node]=true;
        res.add(node);
        for(int it:adj.get(node))
        {
            if(visited[it]==false)
                 dfs(res,adj,visited,it);
        }
    }
    
}