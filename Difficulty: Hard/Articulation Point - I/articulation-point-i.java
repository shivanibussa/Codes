//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution
{
    private int timer=0;
    public void dfs(int node,int parent,int[] vis,int[] low, int[] tin,int[] mark,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        low[node]=tin[node]=timer;
        timer++;
        int child=0;
        for(int it:adj.get(node))
        {
            if(it==parent)
                continue;
            if(vis[it]==0)
            {
                dfs(it,node,vis,low,tin,mark,adj);
                low[node] = Math.min(low[node],low[it]);
                
                if(low[it]>=tin[node] && parent!=-1)
                {
                    mark[node]=1;
                }
                child++;
            }
            else
            {
                low[node] = Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1)
            mark[node]=1;
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
       int vis[] = new int[V];
       int tin[] = new int[V];
       int low[] = new int[V];
       int mark[] = new int[V];
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i=0;i<V;i++)
       {
           if(vis[i]==0)
            {
                dfs(i,-1,vis,low,tin,mark,adj);
            }
       }
       for(int i=0;i<V;i++)
       {
           if(mark[i]==1)
            ans.add(i);
       }
       if(ans.size()==0)
            ans.add(-1);
        return ans;
    }
}