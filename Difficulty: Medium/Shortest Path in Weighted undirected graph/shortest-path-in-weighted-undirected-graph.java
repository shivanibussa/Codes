class Solution 
{
    public List<Integer> shortestPath(int V, int m, int edges[][]) 
    {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[V+1];
        int parent[] = new int[V+1];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<=V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0],b=edges[i][1],c=edges[i][2];
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }
        
        pq.add(new int[]{0,1});
        dist[1] = 0;
        parent[1] = 1;
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int w = pop[0];
            int v = pop[1];
            
            for(int[] neigh:adj.get(v))
            {
                int nv = neigh[0];
                int nw = neigh[1];
                if(w+nw<dist[nv])
                {
                    dist[nv] = w+nw;
                    parent[nv] = v;
                    pq.add(new int[]{dist[nv],nv});
                }
            }
        }
        if(dist[V]==(int)1e9)
        {
           res.add(-1);
             return res; // No path exists
        }
        int n = V;
        
        int totalWeight = dist[n];
        res.add(n);
        while (parent[n] != n) 
        {
            n = parent[n];
            res.add(n);
        }
        Collections.reverse(res);
        res.add(0, totalWeight);
        
        return res;
        
        // res.add(-1);
        //      return res; // No path exists
        // }
        
        
        // int totalWeight = dist[n];
        // res.add(n);
        // while (parent[n] != n) 
        // {
        //     n = parent[n];
        //     res.add(n);
        // }
        // Collections.reverse(res);
        // res.add(0, totalWeight);
        
        // return res;
    }
}