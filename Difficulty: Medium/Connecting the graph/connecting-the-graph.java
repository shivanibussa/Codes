//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

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

    public int Solve(int n, int[][] edges) 
    {
        DisjointSet ds = new DisjointSet(n);
        int extras=0,cnt=0;
        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];
            if(ds.findUparent(u)==ds.findUparent(v))
                extras++;
            else
                ds.UnionBySize(u,v);
        }
        for(int i=0;i<n;i++)
        {
            if(i==ds.parent.get(i))
                cnt++;
        }
        
        return extras>=cnt-1 ? cnt-1 :-1;
    }
}