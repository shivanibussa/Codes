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
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUParent(int node)
{
    if(node == parent.get(node))
    {
        return node;
    }
    // Perform path compression
    parent.set(node, findUParent(parent.get(node)));
    return parent.get(node);
}

    
    public void UnionBySize(int u,int v)
    {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
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
// class Edge implements Comparable<Edge> {
//     int src, dest, weight;
//     Edge(int _src, int _dest, int _wt) {
//         this.src = _src; this.dest = _dest; this.weight = _wt;
//     }
    
//     public int compareTo(Edge compareEdge) {
//         return this.weight - compareEdge.weight;
//     }
// }
class Solution 
{
    static int spanningTree(int V, int E, List<List<int[]>> adj) 
    {
        DisjointSet ds = new DisjointSet(V);
        int mwt=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<adj.size();i++)
        {
            for (int j = 0; j < adj.get(i).size(); j++)
            {
                int u = i;
                int v = adj.get(i).get(j)[0];
                int wt = adj.get(i).get(j)[1];
                
                pq.offer(new int[]{wt,u,v});
            }
        }
        
        while(!pq.isEmpty())
        {
            int pops[] = pq.poll();
            int wt = pops[0];
            int u = pops[1];
            int v = pops[2];
            
            if(ds.findUParent(u)!=ds.findUParent(v))
            {
                ds.UnionBySize(u,v);
                mwt+=wt;
            }
            // else
            // {
            //     continue;
            // }
        }
        return mwt;
    }
    
}
