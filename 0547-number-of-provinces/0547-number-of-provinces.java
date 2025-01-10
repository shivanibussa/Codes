class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        int res=0;
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                res++;
                bfs(i,isConnected,visited);
            }
        }
        return res;
    }
    public void bfs(int node,int[][] isConnected,boolean visited[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int i=0;i<isConnected.length;i++)
            {
                if(isConnected[pop][i]==1 && visited[i]==false)
                {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}