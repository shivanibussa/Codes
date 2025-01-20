//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution 
{
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) 
    {
        Queue<int[]> q = new LinkedList<>();
        int dist[] = new int[n];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<flights.length;i++)
        {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            
            adj.get(u).add(new int[]{v,wt});
            
        }
        dist[src]=0;
        q.offer(new int[]{0,src,0});
        while(!q.isEmpty())
        {
            int pops[] = q.poll();
            int a = pops[0];
            int b = pops[1];
            int c = pops[2];
            
            for(int adjn[]:adj.get(b))
            {
                int ver = adjn[0];
                int cost = adjn[1];
                if (a > k) continue;
                if(dist[ver]>c+cost && a<=k)
                {
                    dist[ver] = c+cost;
                    q.offer(new int[]{a+1,ver, c+cost});
                }
            }
            
        }
        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        else
            return dist[dst];
    }
}