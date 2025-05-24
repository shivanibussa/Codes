class Solution 
{
    public boolean isBipartite(int[][] graph) 
    {
        int V = graph.length;
        int color[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            color[i] = -1;
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(bfs(i,color,graph)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean bfs(int node,int color[],int graph[][])
    {
        color[node] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int it:graph[pop])
            {
                if(color[it]==-1)
                {
                    color[it] = 1-color[pop];
                    q.add(it);
                }
                else if(color[it]==color[pop])
                {
                    return false;
                }
            }
        }
        return true;
    }
}