class DisjointSet
{
    ArrayList<Integer> parent;
    ArrayList<Integer> size;
    DisjointSet(int V)
    {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int getUParent(int node)
    {
        if(node==parent.get(node))
            return node;
            
        int ulp = getUParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void UnionBySize(int u,int v)
    {
        int ulp_u = getUParent(u);
        int ulp_v = getUParent(v);
        if(ulp_u==ulp_v)
            return;
        if(size.get(ulp_u)>size.get(ulp_v))
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution 
{
    static int spanningTree(int V, int E, List<List<int[]>> edges) 
    {
      DisjointSet ds = new DisjointSet(V);
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
      int res=0;
      for(int i=0;i<edges.size();i++)
      {
          for(int j=0;j<edges.get(i).size();j++)
            {
                int an = edges.get(i).get(j)[0];
                int wt = edges.get(i).get(j)[1];
                
                pq.offer(new int[]{wt,i,an});
            }
      }
      while(!pq.isEmpty())
      {
          int pop[] = pq.poll();
          int u = pop[1];
          int v = pop[2];
          int wt = pop[0];
          if(ds.getUParent(u)!=ds.getUParent(v))
          {
              ds.UnionBySize(u,v);
              res+=wt;
          }
      }
      return res;
    }
}