// User function Template for Java
class Solution 
{

    public int[] shortestPath(int V, int E, int[][] edges) 
    {
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        int indegree[] = new int[V];
        int dist[] = new int[V];
        Queue<Integer>q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = (int)1e9;
        }
        for(int i=0;i<E;i++)
        {
            int a = edges[i][0], b = edges[i][1], wt = edges[i][2];
            adj.get(a).add(new int[]{b,wt});
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
            al.add(pop);
            
            for(int it[]:adj.get(pop))
            {
                int node = it[0];
                indegree[node]--;
                if(indegree[node]==0)
                {
                    q.add(node);
                }
            }
        }
        dist[0]=0;
        for(int vertex:al)
        {
            for(int it[]:adj.get(vertex))
            {
                int nv = it[0],wt = it[1];
                if(dist[vertex]+wt<dist[nv])
                {
                    dist[nv] = wt+dist[vertex];
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==(int)1e9)
                dist[i]=-1;
        }
        return dist;
    }
}