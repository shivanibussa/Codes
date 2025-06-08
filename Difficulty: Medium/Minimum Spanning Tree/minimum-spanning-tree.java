class Solution 
{
    static int spanningTree(int V, int E, List<List<int[]>> adj)
    {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int vis[] = new int[V];
        int res=0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int wt = pop[0];
            int v = pop[1];
            if(vis[v]==1)
                continue;
            vis[v]=1;
            res+=wt;
            
            for(int it[]:adj.get(v))
            {
                int nv = it[0];
                int nw = it[1];
                if(vis[nv]==0)
                pq.offer(new int[]{nw,nv});
            }
        }
        return res;
    }
}