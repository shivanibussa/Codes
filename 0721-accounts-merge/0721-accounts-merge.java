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
    
    public int findUparent(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        parent.set(node,findUparent(parent.get(node)));
        return parent.get(node);
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
            size.set(ulp_v,(size.get(ulp_u)+size.get(ulp_v)));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,(size.get(ulp_u)+size.get(ulp_v)));
        }
    }
    
    
}

class Solution 
{
  static List<List<String>> accountsMerge(List<List<String>> accounts) 
  {
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    HashMap<String, Integer> hm = new HashMap<>();
    for(int i=0;i<accounts.size();i++)
    {
        for(int j=1;j<accounts.get(i).size();j++)
        {
            String email = accounts.get(i).get(j);
            if(hm.containsKey(accounts.get(i).get(j))==false)
            {
                hm.put(accounts.get(i).get(j),i);
            }
            else
            {
                ds.UnionBySize(i,hm.get(email));
            }
        }
    }
    
    
    ArrayList<String> merged[] = new ArrayList[n];
    for(int i=0;i<n;i++)
    {
        merged[i]=(new ArrayList<String>());
    }
    
    for(Map.Entry<String,Integer> es:hm.entrySet())
    {
        String s = es.getKey();
        int id = es.getValue();
        int root = ds.findUparent(id);
        merged[root].add(s);
    }
    List<List<String>> ans= new ArrayList<>();
    for(int i=0;i<merged.length;i++)
    {
        if(merged[i].size()==0)
            continue;
        Collections.sort(merged[i]);
        ArrayList<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String it:merged[i])
        {
            temp.add(it);
        }
        ans.add(temp);
    }
    return ans;

  }
}
     