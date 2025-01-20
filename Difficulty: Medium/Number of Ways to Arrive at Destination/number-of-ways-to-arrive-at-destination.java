//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution 
{
    static int countPaths(int n, List<List<Integer>> roads) 
    {
       List<List<int[]>> adj = new ArrayList<>();
       long[] dist = new long[n];  // Changed to long to avoid overflow
       int[] ways = new int[n];
       PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));  // Changed to long[]
       int mod = (int)(1e9+7);
       pq.offer(new long[]{0, 0});  // Changed to long[]
      
       for(int i=0; i<n; i++)
       {
           dist[i] = Long.MAX_VALUE;  // Changed to Long.MAX_VALUE
           adj.add(new ArrayList<>());
       }
       dist[0] = 0;
       ways[0] = 1;
       
       for(List<Integer> road : roads)
       {
           int u = road.get(0);
           int v = road.get(1);
           int wt = road.get(2);
           adj.get(u).add(new int[]{v, wt});
           adj.get(v).add(new int[]{u, wt});
       }
       
       while(!pq.isEmpty())
       {
           long[] pops = pq.poll();
           long d = pops[0];
           int node = (int)pops[1];
           
           if (d > dist[node]) continue;  // Skip if we've found a better path already
           
           for(int[] adjn : adj.get(node))
           {
               int ver = adjn[0];
               int cost = adjn[1];
               long newDist = d + cost;
               
               if(newDist < dist[ver])
               {
                   dist[ver] = newDist;
                   ways[ver] = ways[node];
                   pq.offer(new long[]{newDist, ver});
               }
               else if(newDist == dist[ver])
               {
                   ways[ver] = (ways[ver] + ways[node]) % mod;
               }
           }
       }
       
       return ways[n-1];
    }
}
