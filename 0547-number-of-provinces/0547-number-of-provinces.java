class DisjointSet
{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }   
    
    
    public int getUparent(int node)
    {
        if(node==parent.get(node))
            return node;
        int ulp = getUparent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    
    public void unionBySize(int u,int v)
    {
        int ulp_u = getUparent(u);
        int ulp_v = getUparent(v);
        
        if(ulp_u==ulp_v)
            return;
            
        else if(size.get(ulp_u)>size.get(ulp_v))
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
    public int findCircleNum(int[][] adj) 
    {
        int V = adj.length,cntC=0;
        DisjointSet ds = new DisjointSet(V);
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int res=0;
        for(int i=0;i<adj.length;i++)
        {
            for(int j=0;j<adj[0].length;j++)
            {
                if(adj[i][j]==1)
                {
                    if(ds.getUparent(i)!=ds.getUparent(j))
                    {
                        ds.unionBySize(i,j);
                    }
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(ds.parent.get(i)==i)
            {
                cntC++;
            }
        }
        return cntC;
    }
}