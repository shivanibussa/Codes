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


class Solution 
{

    public int[] shortestPath(int V, int E, int[][] edges) 
    {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        int dist[] = new int[V];
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v,wt});
        }
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,adj,st,visited);
            }
        }
        
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        while(!st.isEmpty())
        {
            int pop = st.pop();
            for(int i=0;i<adj.get(pop).size();i++)
            {
                int node = adj.get(pop).get(i)[0];
                int weight = adj.get(pop).get(i)[1];
                
                if(dist[pop] != Integer.MAX_VALUE && dist[pop] + weight < dist[node])
                    dist[node] = dist[pop]+weight;
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
    public void dfs(int node, ArrayList<ArrayList<int[]>> adj,Stack<Integer> st, boolean visited[])
    {
        visited[node] = true;
        for(int i=0;i<adj.get(node).size();i++)
        {
            int neighbor = adj.get(node).get(i)[0];
            if(!visited[neighbor])
            {
                dfs(neighbor,adj,st,visited);
            }
        }
        st.push(node);
    }
}