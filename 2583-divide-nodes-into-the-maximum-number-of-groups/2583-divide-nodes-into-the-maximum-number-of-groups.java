class Solution 
{
    public int magnificentSets(int n, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n + 1];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(i, adj, visited, component)) {
                    return -1; 
                }
                result += getMaxGroups(component, adj);
            }
        }

        return result;
    }

    private boolean isBipartite(int start, ArrayList<ArrayList<Integer>> adj, int[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1; 
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = -visited[node]; 
                    queue.offer(neighbor);
                    component.add(neighbor);
                } else if (visited[neighbor] == visited[node]) {
                    // Not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    
    private int getMaxGroups(List<Integer> component, ArrayList<ArrayList<Integer>> adj) {
        int maxGroups = 0;

        for (int node : component) {
            maxGroups = Math.max(maxGroups, bfsDepth(node, adj));
        }

        return maxGroups;
    }

    private int bfsDepth(int start, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        queue.offer(start);
        depth.put(start, 1); // Start with depth 1

        int maxDepth = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDepth = depth.get(node);

            for (int neighbor : adj.get(node)) {
                if (!depth.containsKey(neighbor)) {
                    depth.put(neighbor, currentDepth + 1);
                    queue.offer(neighbor);
                    maxDepth = Math.max(maxDepth, currentDepth + 1);
                }
            }
        }

        return maxDepth;
    }
}