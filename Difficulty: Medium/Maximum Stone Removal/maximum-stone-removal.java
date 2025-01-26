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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

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

    int maxRemove(int[][] stones, int n) 
    {
        int maxrow = 0;
        int maxcol = 0;
        
        for(int i=0;i<n;i++)
        {
            maxrow = Math.max(maxrow,stones[i][0]);
            maxcol = Math.max(maxcol,stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxrow+maxcol+2);
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int noderow = stones[i][0];
            int nodecol = stones[i][1]+maxrow+1;
            ds.UnionBySize(noderow,nodecol);
            hm.put(noderow,1);
            hm.put(nodecol,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet())
        {
            if(ds.findUparent(entry.getKey())==entry.getKey())
            {
                cnt++;
            }
        }
        return n-cnt;
    }
};
