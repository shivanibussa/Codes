class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> adj = new ArrayList<>();
        int[] cost = new int[n];
        int[] time = new int[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
            time[i] = Integer.MAX_VALUE; 
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }
        cost[0] = passingFees[0];
        time[0] = 0;
        q.offer(new int[]{cost[0], time[0], 0});

        while(!q.isEmpty()) {
            int[] pops = q.poll();
            int c = pops[0];
            int t = pops[1];
            int v = pops[2];

            if(v == n-1) return c;

            if(t > maxTime) continue;

            for(int[] neighbor : adj.get(v)) {
                int vertex = neighbor[0];
                int newTime = t + neighbor[1];
                int newCost = c + passingFees[vertex];
                
                if(newTime <= maxTime && (newCost < cost[vertex] || newTime < time[vertex])) {
                    cost[vertex] = newCost;
                    time[vertex] = newTime;
                    q.offer(new int[]{newCost, newTime, vertex});
                }
            }
        }

        return -1;
    }
}
