class Solution 
{
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        ArrayList<Integer>res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean visited[] = new boolean[V];
        visited[0] = true;
        while(!q.isEmpty())
        {
            int pop = q.poll();
            res.add(pop);
            for(int it:adj.get(pop))
            {
                if(visited[it]==false)
                {
                    q.add(it);
                    visited[it] = true;
                }
            }
        }
        return res;
    }
}