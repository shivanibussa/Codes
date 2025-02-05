class Solution 
{
    public int magnificentSets(int n, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int res=0;
        int visited[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i=1;i<n+1;i++)
        {
            List<Integer> component = new ArrayList<>();
            if(visited[i]==0)
            {
                if(bipartite(i,adj,visited,component)==false)
                    return -1;
                else
                {
                    res+=maxgroups(component,adj);
                }
            }
        }
        return res;
    }
    public boolean bipartite(int node,ArrayList<ArrayList<Integer>> adj,int visited[],List<Integer> component)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node]=1;
        component.add(node);

        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int it:adj.get(pop))
            {
                if(visited[it]==0)
                {
                    visited[it]=-visited[pop];
                    q.offer(it);
                    component.add(it);
                }
                else if(visited[it]==visited[pop])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int maxgroups(List<Integer> comp,ArrayList<ArrayList<Integer>> adj)
    {
        int maxg =0;
        for(int n:comp)
        {
            maxg = Math.max(maxg,bfs(n,adj));
        }
        return maxg;
    }
    public int bfs(int node,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer> depth = new HashMap<>();
        q.offer(node);
        depth.put(node,1);

        int md=1;

        while(!q.isEmpty())
        {
            int pop = q.poll();
            int cd = depth.get(pop);

            for(int it:adj.get(pop))
            {
                if(!depth.containsKey(it))
                {
                    depth.put(it,cd+1);
                    q.offer(it);
                    md = Math.max(md,cd+1);
                }
            }
        }
        return md;
    }
}