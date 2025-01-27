//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution 
{
    public void dfs(int node, int []visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=1;
        
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
                dfs(it,visited,st,adj);
        }
        st.push(node);
    }
    public void dfs2(int node,int visited[],ArrayList<ArrayList<Integer>> adjT)
    {
        visited[node]=1;
        for(int it:adjT.get(node))
        {
            if(visited[it]==0)
            {
                dfs2(it,visited,adjT);
            }
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        int visited[] = new int[adj.size()];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<adj.size();i++)
        {
            if(visited[i]==0)
            {
                dfs(i,visited,st,adj);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<adj.size();i++)
        {
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++)
        {
             visited[i]=0;
            for(int it:adj.get(i))
            {
               
                adjT.get(it).add(i);
            }
        }
        int cnt=0;
        while(!st.isEmpty())
        {
            int pop = st.pop();
            if(visited[pop]==0)
            {
                cnt++;
                dfs2(pop,visited,adjT);
            }
        }
        return cnt;
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