//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution 
{
    
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) 
    {
        int V = adj.size();
        int dist[] = new int[V];
        int visited[] = new int[V];
        Queue<Integer>q = new LinkedList<>();
        
        for(int i=0;i<V;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[src]=0;
        q.add(src);
        visited[src]=1;
        while(!q.isEmpty())
        {
            int pop = q.poll();
            for(int it:adj.get(pop))
            {
                if(visited[it]==0)
                {
                    visited[it]=1;
                    q.add(it);
                }
                dist[it] = Math.min(dist[it],1+dist[pop]);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
}
