//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution 
{
    public boolean isBipartite(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int color[] = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
            color[i]=-1;
        }
        for(int pair[]:edges)
        {
            int x = pair[0];
            int y = pair[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(i,adj,color,0)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> adj, int color[],int col)
    {
        color[node]=col;
        for(int it:adj.get(node))
        {
            if(color[it]==-1)
            {
                if(dfs(it,adj,color,1-col)==false)
                    return false;
            }
            else if(color[node]==color[it])
            {
                return false;
            }
        }
        return true;
    }
}