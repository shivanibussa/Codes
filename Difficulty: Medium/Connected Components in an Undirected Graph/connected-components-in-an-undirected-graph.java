
class Solution 
{
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> path = new ArrayList<>();
                bfs(adj,visited,path,i);
                res.add(path);
            }
        }
        return res;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer> path,int node)
    {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while(!q.isEmpty())
        {
            int pop = q.poll();
            path.add(pop);
            for(int it:adj.get(pop))
            {
                if(!visited[it])
                {
                    q.add(it);
                    visited[it]=true;
                }
            }
        }
    }
}