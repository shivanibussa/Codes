class Solution 
{
    
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer> q = new LinkedList<>();
        int V = adj.size();
        int visited[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        q.add(0);
        while(!q.isEmpty())
        {
            int pop = q.poll();
            visited[pop] = 1;
            for(int it:adj.get(pop))
            {
                if(visited[it]==0)
                {
                    q.add(it);
                    visited[it]=1;
                }
            }
            res.add(pop);
        }
        return res;
    }
}