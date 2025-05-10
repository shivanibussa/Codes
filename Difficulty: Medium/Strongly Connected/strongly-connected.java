//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution 
{
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st, boolean visited[])
    {
        visited[node] = true;
        for(int it:adj.get(node))
        {
            if(!visited[it])
            {
                dfs(it,adj,st,visited);
            }
            
        }
        st.push(node);
    }
    public void dfs2(int node,ArrayList<ArrayList<Integer>> adj, boolean visited[])
    {
        visited[node] = true;
        for(int it:adj.get(node))
        {
            if(!visited[it])
            {
                dfs2(it,adj,visited);
            }
            
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size(),scc=0;
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<adj.size();i++)
        {
            if(!visited[i])
            {
                dfs(i,adj,st,visited);
            }
        }
        for(int i=0;i<V;i++)
        {
            adjT.add(new ArrayList<>());
            visited[i] = false;
        }
        
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }
        
        while(!st.isEmpty())
        {
            int i = st.pop();
            if(!visited[i])
            {
                scc++;
                dfs2(i,adjT,visited);
            }
        }
        return scc;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
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
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends