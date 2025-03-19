class DisjointSet{
    
    ArrayList<Integer> size;
    ArrayList<Integer> parent;
    
    DisjointSet(int n)
    {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUparent(int node)
    {
        if(node==parent.get(node))
            return node;
        int root = findUparent(parent.get(node));
        parent.set(node,root);
        return root;
    }
    
    public void UnionBySize(int u,int v)
    {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);
        if(ulp_u==ulp_v)
            return;
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        int res[] = new int[2];
        DisjointSet ds = new DisjointSet(n+1);
        int extras=0,cnt=0;
        for(int edge[]:edges)
        {
            int a = edge[0];
            int b = edge[1];
            
            if(ds.findUparent(a)==ds.findUparent(b))
            {
                return edge;
            }
            else
            {
                ds.UnionBySize(a,b);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(i==ds.parent.get(i))
                cnt++;
        }
        
        return new int[0];
    }
}