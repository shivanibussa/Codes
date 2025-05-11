//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int timer = 1;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        boolean visited[] = new boolean[V];
        int tin[] = new int[V];
        int low[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        int mark[] = new int[V];
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges)
        {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,-1,adj,visited,tin,low,mark);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(mark[i]==1)
            {
                res.add(i);
            }
        }
        if(res.size()==0)
            res.add(-1);
        return res;
        
    }
    public static void dfs(int node,int parent,List<List<Integer>> adj,boolean visited[],int tin[],int low[],int mark[])
    {
        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        int child = 0;
        for(int it:adj.get(node))
        {
            if(!visited[it])
            {
                dfs(it,node,adj,visited,tin,low,mark);
                low[node] = Math.min(low[it],low[node]);
                if(low[it]>=tin[node] && parent!=-1)
                {
                    mark[node] = 1;
                }
                child++;
            }
            else
            {
                low[node] = Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1)
        {
            mark[node]=1;
        }
    }
}