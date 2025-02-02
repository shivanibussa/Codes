class DisjointSet
{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node)
    {
        if(node==parent.get(node))
            return node;
        parent.set(node,findUParent(parent.get(node)));
        return parent.get(node);
    }

    public void UnionBySize(int u,int v)
    {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

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
class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n =0;
        int res[] = new int[2];
        for(int edge[]:edges)
        {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        DisjointSet ds = new DisjointSet(n+1);

        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findUParent(u)==ds.findUParent(v))
            {
                res[0]=u;
                res[1]=v;
            }
            else
            {
                ds.UnionBySize(u,v);
            }

        }
        return res;
    }
}