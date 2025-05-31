class Solution 
{
    public boolean canFinish(int V, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());

        }        
        for(int preq[]:prerequisites)
        {
            int a = preq[0];
            int b = preq[1];
            adj.get(a).add(b);
            indegree[b]++;
        }

        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            int pop = q.poll();
            cnt++;
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        return cnt==V ? true:false;
    }
}