//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution 
{
    public void dfs(int node,int visited[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
    {
        visited[node]=1;
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            dfs(it,visited,adj,st);
        }
        st.push(node);
    }
    public void dfs3(int node,int visited[],ArrayList<ArrayList<Integer>> adjT)
    {
        visited[node]=1;
        for(int it:adjT.get(node))
        {
            if(visited[it]==0)
            dfs3(it,visited,adjT);
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        Stack<Integer> st = new Stack<>();
        int visited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,visited,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjT.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            visited[i]=0;
            for(int it:adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }
        
        int scc=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(visited[node]==0)
            {
                scc++;
                dfs3(node,visited,adjT);
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