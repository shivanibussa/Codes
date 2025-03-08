//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution 
{
    public List<Integer> shortestPath(int n, int m, int edges[][]) 
    {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int dist[] = new int[n+1];
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int parent[] = new int[n+1];
        
        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<int[]>());
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        for(int i=0;i<m;i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            int c = edges[i][2];
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }
        q.add(new int[]{0,1});
        dist[1] = 0;
        parent[1] = 1;
        while(!q.isEmpty())
        {
            int pop[] = q.poll();
            int w = pop[0];
            int v = pop[1];
            
            for(int[] neigh:adj.get(v))
            {
                int nv = neigh[0];
                int nw = neigh[1];
                if(w+nw<dist[nv])
                {
                    dist[nv] = w+nw;
                    parent[nv] = v;
                    q.add(new int[]{dist[nv],nv});
                }
            }
        }
        
        if (dist[n] == Integer.MAX_VALUE) 
        {
            res.add(-1);
             return res; // No path exists
        }
        
        
        int totalWeight = dist[n];
        res.add(n);
        while (parent[n] != n) 
        {
            n = parent[n];
            res.add(n);
        }
        Collections.reverse(res);
        res.add(0, totalWeight);
        
        return res;
    }
}