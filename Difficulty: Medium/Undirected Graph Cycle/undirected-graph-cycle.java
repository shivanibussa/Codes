//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution 
{

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    {
        int n = adj.size();
        int visited[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                if(helper(i,visited,adj)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(int node,int visited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node,-1});
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int vertex = pop[0];
            int parent = pop[1];
            
            for(int adjnode:adj.get(vertex))
            {
                if(visited[adjnode]!=1)
                {
                    q.offer(new int[]{adjnode,vertex});
                    visited[adjnode]=1;
                }
                else if(adjnode!=parent)
                {
                    return true;
                }
            }
        }
        return false;
    }
}