class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        int V = edges.length;
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<edges[i].length;j++)
            {
                adj.get(edges[i][j]).add(i);
                indegree[i]++;
            }
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
        Collections.sort(res);
        return res;
    }
}