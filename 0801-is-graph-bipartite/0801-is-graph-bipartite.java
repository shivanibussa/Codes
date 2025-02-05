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
                if(bipartite(i,color,graph)==false)
                    return false;
            }

        }
        return true;
        
    }
     public boolean bipartite(int node,int color[],int[][] graph)
     {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1;

        while(!q.isEmpty())
        {
            int pop = q.poll();

            for(int it:graph[pop])
            {
                if(color[it]==-1)
                {
                    q.add(it);
                    color[it]=1-color[pop];
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

    