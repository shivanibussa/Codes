//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution 
{
    public static ArrayList<Integer> topoSort(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int visited[] = new int[V];
        
        for(int i =0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int pair[]:edges)
        {
            int a = pair[0], b = pair[1];
            adj.get(a).add(b);
        }
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,adj,visited,st);
            }
        }
        while(!st.isEmpty())
        {
            al.add(st.pop());
        }
        return al;
        
    }
    public static void dfs(int node, List<List<Integer>> adj, int visited[], Stack<Integer> st)
    {
        visited[node]=1;
        
        for(int nv:adj.get(node))
        {
            if(visited[nv]==0)
            {
                dfs(nv,adj,visited,st);
            }
        }
        st.push(node);
    }
}