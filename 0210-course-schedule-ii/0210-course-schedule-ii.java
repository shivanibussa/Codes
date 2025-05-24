class Solution {
    public int[] findOrder(int V, int[][] edges) 
    {
       int indegree[] = new int[V];
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       int res[] = new int[V];
       int c=0;
       for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
       for(int i=0;i<edges.length;i++)
       {
           int a = edges[i][0];
           int b = edges[i][1];
           
           adj.get(b).add(a);
           indegree[a]++;
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
           res[c++] = pop;
           for(int it:adj.get(pop))
           {
               indegree[it]--;
               if(indegree[it]==0)
               {
                   q.add(it);
               }
           }
       }
       if(c!=V)
        return new int[]{};
       else
        return res;
    }
}