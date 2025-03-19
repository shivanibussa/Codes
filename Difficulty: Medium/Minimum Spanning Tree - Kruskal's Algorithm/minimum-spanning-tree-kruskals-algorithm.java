//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[E][3];
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }
            ot.println(new Solution().kruskalsMST(V, edges));
            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
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
    
    static int kruskalsMST(int V, int[][] edges) 
    {
     
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int mst=0;
        DisjointSet ds = new DisjointSet(V);
        for(int i=0;i<edges.length;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            int wt = edges[i][2];
            pq.offer(new int[]{wt,a,b});
        }
        while(!pq.isEmpty())
        {
            int pop[] = pq.poll();
            int wt = pop[0];
            int u = pop[1];
            int v = pop[2];
            
            if(ds.findUparent(u) != ds.findUparent(v))
            {
                mst+=wt;
                ds.UnionBySize(u,v);
            }
        }
        return mst;
    }
}
