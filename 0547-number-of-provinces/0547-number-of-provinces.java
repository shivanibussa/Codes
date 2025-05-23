class Solution 
{
    public int findCircleNum(int[][] adj) 
    {
        int V = adj[0].length,cnt=0;
        boolean visited[] = new boolean[V];  
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                cnt++;
                bfs(adj,visited,i);
            }
        }
        return cnt;
    }
    public void bfs(int adj[][],boolean visited[],int node)
    {
        visited[node]=true;
        int V = visited.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int i=0;i<V;i++)
            {
                if(adj[pop][i]==1 && visited[i]==false)
                {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}