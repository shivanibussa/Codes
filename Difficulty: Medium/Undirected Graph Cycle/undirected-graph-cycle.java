//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                boolean bool = dfs(i,-1,visited,adj);
                if(bool==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int z,int p,boolean visited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[z]=true;
        for(int neighbor:adj.get(z))
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,z,visited,adj)==true)
                    return true;
            }
            else if(visited[neighbor]==true && neighbor!=p)
            {
                return true;
            }
        }
        return false;
    }
}