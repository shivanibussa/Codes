//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class DisjointSet{
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
    
    public void UnionBySize(int u, int v)
    {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);
        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, (size.get(ulp_v)+size.get(ulp_u)));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, (size.get(ulp_v)+size.get(ulp_u)));
        }
    }
}
class Solution 
{
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) 
    {
        DisjointSet ds = new DisjointSet(V);
        int cnt=0;
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(adj.get(i).get(j)==1)
                {
                    ds.UnionBySize(i,j);
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(ds.parent.get(i)==i)
            cnt++;
        }
        return cnt;
    }
};