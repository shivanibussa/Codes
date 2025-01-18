//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DriverClass {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<iPair>> adj = new ArrayList<ArrayList<iPair>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<iPair>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                iPair t1 = new iPair(v, w);
                iPair t2 = new iPair(u, w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int src = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.dijkstra(adj, src);

            for (i = 0; i < V; i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// class iPair 
// {
//     int distance, node;
//     iPair(int distance, int node) 
//     {
//         this.distance = distance;
//         this.node = node;
//     }
// }



class Solution 
{
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) 
    {
        PriorityQueue<iPair> q = new PriorityQueue<>((x,y)->x.first-y.first);
        q.add(new iPair(0,src));
        int V = adj.size();
        
       ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            dist.add((int) 1e9); // Fill the list with "infinity"
        }
        dist.set(src, 0); 
        while(!q.isEmpty())
        {
            iPair p = q.poll();
            int dista = p.first;
            int vertex = p.second;
            
            for(iPair p1:adj.get(vertex))
            {
                int v = p1.first;
                int d = p1.second;
                if(dist.get(v)>dista+d)
                {
                    dist.set(v,dista+d);
                    q.offer(new iPair(dist.get(v),v));
                }
            }
        }
        return dist;
    }
}