class DisjointSet
{
    ArrayList<Integer> parent;
    ArrayList<Integer> size;
    public DisjointSet(int V)
    {
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int getUparent(int node)
    {
        if(node==parent.get(node))
            return node;

        int ulp_u = getUparent(parent.get(node));
        parent.set(node,ulp_u);
        return parent.get(node);
    }

    public void unionBySize(int u,int v)
    {
        int ulp_u = getUparent(u);
        int ulp_v = getUparent(v);
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
    public int makeConnected(int n, int[][] connections) 
    {
        DisjointSet ds = new DisjointSet(n);
        int extras = 0, connComp = 0; 
        for(int i=0;i<connections.length;i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.getUparent(u)==ds.getUparent(v))
            {
                extras++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i)
                connComp++;
        }
        int ans = connComp-1;
        if(extras>=connComp-1)
            return ans;
        else
            return -1;
    }
}