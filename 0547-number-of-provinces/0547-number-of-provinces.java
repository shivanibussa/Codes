class Solution 
{
    public int findCircleNum(int[][] adj) 
    {
       int cnt=0;
       int V = adj.length;
       boolean visited[] = new boolean[V];
       for(int i=0;i<V;i++)
       {
           if(!visited[i])
           {
               cnt++;
               bfs(i,adj,visited);
           }
       }
       return cnt;
    }
    public void bfs(int node,int[][] adj,boolean visited[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty())
        {
            int poll = q.poll();
            for(int i=0;i<adj.length;i++)
            {
                if(adj[poll][i]==1 && visited[i]==false)
                {
                    q.add(i);
                    visited[i] = true;
                }
            }
        } 
    }
}