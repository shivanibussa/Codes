class Solution 
{
    static int spanningTree(int V, int E, List<List<int[]>> adj) 
    {
      int visited[] = new int[V];
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
      int res=0;
      pq.offer(new int[]{0,0});
      while(!pq.isEmpty())
      {
          int pop[] = pq.poll();
          int wt = pop[0];
          int vertex = pop[1];
          if(visited[vertex]==1)
            continue;
          visited[vertex] =1;   
          res+=wt;
          
          for(int it[]:adj.get(vertex))
          {
              int nv = it[0];
              int nw = it[1];
              if(visited[nv]==0)
              {
                  pq.offer(new int[]{nw,nv});
              }
          }
      }
      return res;
    }
}