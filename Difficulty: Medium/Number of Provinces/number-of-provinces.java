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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) 
    {
        DisjointSet ds = new DisjointSet(V);
        int cnt = 0;
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                if(adj.get(i).get(j)==1)
                {
                    ds.UnionBySize(i,j);
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(i==ds.parent.get(i))
                cnt++;
                
        }
        return cnt;
    }
};