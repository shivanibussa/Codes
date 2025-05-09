//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
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
    public int[] shortestPath(int V, int E, int[][] edges) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        int dist[] = new int[V];
        Stack<Integer> st = new Stack<>();
        int visited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
            
        for(int pair[]:edges)
        {
            int u = pair[0], v = pair[1], wt = pair[2];
            adj.get(u).add(new int[]{v,wt});
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(adj,i,visited,st);
            }
        }
        
        dist[0]=0;
        while(!st.isEmpty())
        {
            int pop = st.pop();
            
            for(int it[]:adj.get(pop))
            {
                int nv = it[0];
                int wt = it[1];
                
                if(dist[pop]!=Integer.MAX_VALUE && wt+dist[pop]<dist[nv])
                {
                    dist[nv] = dist[pop]+wt;
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public void dfs(List<List<int[]>> adj, int node,int visited[],Stack<Integer> st)
    {
        visited[node]=1;
        Q
        for(int it[]:adj.get(node))
        {
            int nv = it[0];
            int w = it[1];
            if(visited[nv]==0)
            {
                dfs(adj,nv,visited,st);
            }
        }
        st.push(node);
    }
}