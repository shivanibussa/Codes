//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution 
{
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        boolean visited[] = new boolean[V];
        boolean pathvisited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,pathvisited)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean pathvisited[])
    {
        visited[node] = true;
        pathvisited[node] = true;
        for(int it:adj.get(node))
        {
            if(!visited[it])
            {
                if(dfs(it,adj,visited,pathvisited)==true)
                    return true;
            }
            else if(visited[it] && pathvisited[it])
            {
                return true;
            }
        }
        pathvisited[node] = false;
        
        
        return false;
    }
}