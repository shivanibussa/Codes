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


class Pair{
    int first,second;
    
    Pair(int _f,int _s)
    {
        this.first = _f;
        this.second = _s;
    }
}
class Solution 
{

    public int[] shortestPath(int V, int E, int[][] edges)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();
        int dist[] = new int[V];
    
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<E;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                toposort(visited,adj,st,i);
            }
        }
        for(int i=0;i<V;i++)
        {
            dist[i] = (int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                
                if(dist[node]+wt<dist[v])
                {
                    dist[v]=dist[node]+wt;
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==(int)(1e9))
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
    public void toposort(int[] visited, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st,int node)
    {
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            int v = adj.get(node).get(i).first;
            if(visited[v]==0)
            {
                toposort(visited,adj,st,v);
            }
        }
        st.push(node);
    }
}