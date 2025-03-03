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
        
        boolean visited[] = new boolean[V];
        boolean pathvisited[] = new boolean[V];
        boolean check[] = new boolean[V];
        ArrayList<Integer> safeOnes = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
               dfs(i,adj,visited,pathvisited,safeOnes,check);
            }
        }
        // for(int i=0;i<V;i++)
        // {
        //     if(check[i]==true)
        //     {
        //         safeOnes.add(i);
        //     }
        // }
        Collections.sort(safeOnes);
        return safeOnes;
    }
    public boolean dfs(int node, List<List<Integer>> adj, boolean visited[],
    boolean pathvisited[], ArrayList<Integer> safeOnes,boolean check[])
    {
        visited[node]=true;
        pathvisited[node]=true;
        for(int it:adj.get(node))
        {
            if(!visited[it])
            {
                if(dfs(it,adj,visited,pathvisited,safeOnes,check)==true)
                    return true;
            }
            else if(visited[it] && pathvisited[it])
            {
                return true;
            }
        }
        pathvisited[node] = false;
        // check[node] = true;
        safeOnes.add(node);
        
        return false;
    }
    
}
