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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution 
{
    public boolean isCyclic(int V, int[][] edges) 
    {
       List<List<Integer>> adj = new ArrayList<>();
       int visited[] = new int[V];
       int pathvis[] = new int[V];
       for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
       for(int pair[]:edges)
       {
           int a = pair[0];
           int b = pair[1];
           
           adj.get(a).add(b);
       }
        
       for(int i=0;i<V;i++)
       {
           if(visited[i]==0)
           {
               if(dfs(adj,visited,pathvis,i)==true)
                return true;
           }
       }
       return false;
    }
    
    public boolean dfs(List<List<Integer>> adj, int visited[],int pathvis[],int node)
    {
        visited[node]=1;
        pathvis[node]=1;
        for(int nv:adj.get(node))
        {
            if(visited[nv]==0)
            {
                if(dfs(adj,visited,pathvis,nv)==true)
                    return true;
            }
            else if(pathvis[nv]==1 && visited[nv]==1)
            {
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
}