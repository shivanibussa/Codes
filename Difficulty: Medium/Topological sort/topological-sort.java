class Solution 
{
    public static ArrayList<Integer> topoSort(int V, int[][] edges) 
    {
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<edges.length;i++)
        {
           int a = edges[i][0];
           int b = edges[i][1];
           
           adj.get(a).add(b);
           indegree[b]++;
        }
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int pop = q.poll();
            res.add(pop);
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        return res;
    }
}