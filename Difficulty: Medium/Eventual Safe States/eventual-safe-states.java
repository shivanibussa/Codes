//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) 
    {
        int n = adj.size();
        int visited[] = new int[n];
        int pathvisited[] = new int[n];
        int checked[] = new int[n];
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(adj,visited,pathvisited,checked,arr,i);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(checked[i]==1)
            {
                arr.add(i);
            }
        }
        return arr;
    }
    
    public boolean dfs(List<List<Integer>> adj,int[] visited,int[] pathvisited, int[] checked, 
    ArrayList<Integer> arr,int node)
    {
        visited[node]=1;
        pathvisited[node]=1;
        checked[node]=0;
        
        for(int con:adj.get(node))
        {
            if(visited[con]==0)
            {
                if(dfs(adj,visited,pathvisited,checked,arr,con)==true)
                    return true;
            }
            else if(visited[con]==1 && pathvisited[con]==1)
            {
                checked[node]=0;
                return true;
            }
        }
        checked[node]=1;
        pathvisited[node]=0;
        return false;
    }
}
