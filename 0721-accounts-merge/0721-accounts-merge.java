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
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail))
                {
                    map.put(mail,i);
                }
                else
                {
                    ds.unionBySize(i,map.get(mail));
                }
            }
        }
        ArrayList<String>[] sorted = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            sorted[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> es:map.entrySet())
        {
            String email = es.getKey();
            int node = ds.getUparent(es.getValue());
            sorted[node].add(email);
        }
        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(sorted[i].size()==0)
                continue;

            Collections.sort(sorted[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:sorted[i])
                temp.add(it);

            res.add(temp);
        }
        return res;
    }
}