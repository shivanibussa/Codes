class Solution 
{
    public boolean possibleBipartition(int n, int[][] dislikes) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int likes[] = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<>());
            likes[i]=-1;
        }
        for(int i=0;i<dislikes.length;i++)
        {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        System.out.println(adj);
        for(int i=1;i<n+1;i++)
        {
            if(likes[i]==-1)
            {
                if(bipartite(adj,i,likes,q)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bipartite(ArrayList<ArrayList<Integer>> adj,int node,int likes[],Queue<Integer> q)
    {
        q.offer(node);
        likes[node]=0;

        while(!q.isEmpty())
        {
            int pop=q.poll();
            for(int adjn:adj.get(pop))
            {
                if(likes[adjn]==-1)
                {
                    likes[adjn]=1-likes[pop];
                    q.offer(adjn);
                }
                else if(likes[adjn]==likes[pop])
                {
                    return false;
                }
            }
        }
        return true;
    }
}