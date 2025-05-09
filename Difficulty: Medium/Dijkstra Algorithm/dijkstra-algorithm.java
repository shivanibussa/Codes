//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution 
{
    public int[] dijkstra(int V, int[][] edges, int src) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        int dist[] = new int[V];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int edge[]:edges)
        {
            int a = edge[0];
            int b = edge[1];
            int wt = edge[2];
            
            adj.get(a).add(new int[]{b,wt});
        }
        dist[src] = 0;
        q.add(new int[]{0,src});
        while(!q.isEmpty())
        {
            int popz[] = q.poll();
            int pop = popz[1];
            for(int it[]:adj.get(pop))
            {
                int nv = it[0];
                int w = it[1];
                
                if(dist[pop]+w<dist[nv])
                {
                    dist[nv] = w+dist[pop];
                    q.offer(new int[]{dist[nv],nv});
                }
            }
        }
        return dist;
        
    }
}