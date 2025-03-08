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
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
       int dist[] = new int[n];
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
       
       for(int i=0;i<n;i++)
       {
           dist[i] = Integer.MAX_VALUE;
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<flights.length;i++)
       {
           int a = flights[i][0];
           int b = flights[i][1];
           int c = flights[i][2];
           adj.get(a).add(new int[]{b,c});
       }
    
       dist[src]=0;
       pq.add(new int[]{0,src,0});
       
       while(!pq.isEmpty())
       {
           int pop[] = pq.poll();
           int stops = pop[0];
           int node = pop[1];
           int cost = pop[2];
           if(stops>k)
            continue;
           for(int neigh[]:adj.get(node))
           {
               int nv = neigh[0];
               int nw = neigh[1];
               if(nw+cost<dist[nv] && stops<=k)
               {
                   dist[nv] = cost+nw;
                   pq.add(new int[]{stops+1,nv,dist[nv]});
               }
           }
       }
       if(dist[dst]==Integer.MAX_VALUE)
        return -1;
        return dist[dst];
       
       
    }
}