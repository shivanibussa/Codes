//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution 
{
    public boolean isCycle(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int visited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int pair[]:edges)
        {
            int a = pair[0];
            int b = pair[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]!=1)
            {
                if(bfs(i,adj,visited)==true)
                    return true;
            }
        }
        return false;
        
    }
    public boolean bfs(int node,List<List<Integer>> adj,int visited[])
    {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{node,-1});
        visited[node] = 1;
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int n = pop[0];
            int parent = pop[1];
            for(int nv:adj.get(n))
            {
                if(visited[nv]==1 && nv!=parent)
                    return true;
                else if(visited[nv]==0)
                {
                    q.offer(new int[]{nv,n});
                    visited[nv]=1;
                }
            }
        }
        return false;
    }
}