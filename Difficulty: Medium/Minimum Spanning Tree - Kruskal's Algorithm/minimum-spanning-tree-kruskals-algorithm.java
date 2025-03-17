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
class DisjointSet {
    ArrayList<Integer> parent;
    ArrayList<Integer> size;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUparent(int node) {
        if (node == parent.get(node))
            return node;
        int root = findUparent(parent.get(node));
        parent.set(node, root); // Path compression
        return root;
    }

    public void UnionBySize(int u, int v) {
        int ulp_u = findUparent(u); // Ultimate parent of u
        int ulp_v = findUparent(v); // Ultimate parent of v

        if (ulp_u == ulp_v) return; // Already in the same set

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Solution {
    static int kruskalsMST(int V, int[][] edgeList) {
        // Create a list of edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgeList.length; i++) {
            edges.add(new Edge(edgeList[i][0], edgeList[i][1], edgeList[i][2]));
        }

        // Sort edges based on weight
        Collections.sort(edges);

        // Initialize Disjoint Set
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        // Process edges
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;

            // Check if adding this edge creates a cycle
            if (ds.findUparent(u) != ds.findUparent(v)) {
                mstWt += wt; // Add weight of edge to MST
                ds.UnionBySize(u, v); // Union the two sets
            }
        }
        return mstWt; // Return total weight of MST
    }
}
