//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {

            int V = Integer.parseInt(read.readLine().trim());
            int E = Integer.parseInt(read.readLine().trim());

            int[][] edges = new int[E][3];

            for (int i = 0; i < E; i++) {
                String[] parts = read.readLine().trim().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);

                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }

            // Read source vertex
            int S = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int[] ptr = ob.bellmanFord(V, edges, S);

            // Print the result
            for (int i = 0; i < ptr.length; i++) {
                System.out.print(ptr[i] + " ");
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
    public int[] bellmanFord(int V, int[][] edges, int src) 
    {
        int dist[] = new int[V];
        for(int i=0;i<V;i++)
            dist[i] = (int)1e8;
            
        dist[src] = 0;
        for(int j=0;j<V-1;j++)
        {
            for(int edge[] : edges)
            {
                int a = edge[0];
                int b = edge[1];
                int wt = edge[2];
                
                if(dist[a]!=(int)1e8 && dist[a]+wt<dist[b])
                {
                    dist[b] = dist[a]+wt;
                }
                
            }
        }
        
        for(int i=0;i<1;i++)
        {
            for(int edge[] : edges)
            {
                int a = edge[0];
                int b = edge[1];
                int wt = edge[2];
                
                if(dist[a]!=(int)1e8 && dist[a]+wt<dist[b])
                {
                    return new int[]{-1};
                }
                
            }
        }
        return dist;
    }
}
