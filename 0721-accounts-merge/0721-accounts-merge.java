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
class Solution 
{
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mailMap = new HashMap<>();
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String email = accounts.get(i).get(j);
                if(!mailMap.containsKey(email))
                {
                    mailMap.put(email,i);
                }
                else
                {
                    ds.UnionBySize(i,mailMap.get(email));
                }
            }
        }

        ArrayList<String> merged[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            merged[i] = (new ArrayList<String>());
        for(Map.Entry<String,Integer> es: mailMap.entrySet())
        {
            String mail = es.getKey();
            int id = es.getValue();
            merged[ds.findUparent(id)].add(mail);
        }
        List<List<String>> accountsRes = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(merged[i].size()==0)
                continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(merged[i]);
            temp.addAll(merged[i]);
            accountsRes.add(temp);
        }
        return accountsRes;

    }
}