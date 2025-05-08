class Solution {
    public int[] findOrder(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int al[] = new int[V];
        int c=0;
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[V];
        
        for(int i =0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int pair[]:edges)
        {
            int a = pair[0], b = pair[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty())
        {
            int pop = q.poll();
            al[c++]=pop;
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        if(c!=V)
            return new int[]{};
        else
            return al;
        
    }
}