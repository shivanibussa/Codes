class Solution 
{
    public boolean isBipartite(int[][] graph) 
    {
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0;i<n;i++)
            color[i]=-1;
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(check(i,color,graph,n)==false)
                    return false;
            }
        }
        return true;
    }

    public boolean check(int node, int color[], int graph[][], int n)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=0;

        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int i:graph[pop])
            {
                if(color[i]==-1)
                {
                    q.add(i);
                    color[i] = 1-color[pop];
                }
                else if(color[pop]==color[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
}