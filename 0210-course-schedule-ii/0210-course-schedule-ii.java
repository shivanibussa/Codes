class Solution 
{
    public int[] findOrder(int V, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[V];
        int cnt=0;
        Queue<Integer> q = new LinkedList<>();
        int res[] = new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }        
        for(int preq[]:prerequisites)
        {
            int a = preq[0];
            int b = preq[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int pop = q.poll();
            res[cnt++] = pop;
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        return cnt==V ? res:new int[]{};
    }
}