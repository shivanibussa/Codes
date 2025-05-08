//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        boolean visited[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(adj,res,visited,0);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res,boolean visited[],int node)
    {
        res.add(node);
        visited[node] = true;
        for(int nv:adj.get(node))
        {
            if(!visited[nv])
            {
                dfs(adj,res,visited,nv);
            }
        }
    }
}