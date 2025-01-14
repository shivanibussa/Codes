//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int vertices = Integer.parseInt(read.readLine());
            int edges = Integer.parseInt(read.readLine());

            for (int i = 0; i < vertices; i++) adj.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
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
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) 
    {
        int n = adj.size();
        int visited[] = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(adj,visited,arr,st,i);
            }
        }
        while(!st.isEmpty())
        {
            int pop = st.pop();
            arr.add(pop);
        }
        return arr;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> arr,
    Stack<Integer> st, int node)
    {
        visited[node]=1;
        
        for(int nn:adj.get(node))
        {
            if(visited[nn]==0)
            {
                dfs(adj,visited,arr,st,nn);
            }
        }
        st.push(node);
        
    }
}