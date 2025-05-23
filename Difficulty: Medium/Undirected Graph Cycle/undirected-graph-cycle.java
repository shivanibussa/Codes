class Solution 
{
    public boolean isCycle(int V, int[][] edges)
    {
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
                if(bfs(adj,visited,i))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int node)
    {
        Queue<int[]> q = new LinkedList<>();
        visited[node] = true;
        q.add(new int[]{node,-1});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int popn = pop[0], parent = pop[1];
            for(int it:adj.get(popn))
            {
                if(visited[it]==false)
                {
                    q.add(new int[]{it,popn});
                    visited[it] = true;
                }
                else if(visited[it]==true && it!=parent)
                {
                    return true;
                }
            }
        }
        return false;
    }
}