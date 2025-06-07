class Solution 
{
    public int findCircleNum(int[][] adj) 
    {
        int V = adj.length, cntC=0;
        boolean visited[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(!visited[i]){
                dfs(res,adj,visited,i);
                cntC++;
            }
        }
        return cntC;
    }
    public void dfs(ArrayList<Integer> res, int adj[][],boolean visited[],int node)
    {
        visited[node]=true;
        for(int i=0;i<adj[0].length;i++)
        {
            if(adj[node][i]==1 && visited[i]==false)
                 dfs(res,adj,visited,i);
        }
    }
}