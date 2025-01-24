//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java
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
     