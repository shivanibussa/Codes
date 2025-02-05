// class Solution 
// {
//     int maxs=0;
//     public int magnificentSets(int n, int[][] edges) 
//     {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         // Queue<int[]> q = new LinkedList<>();
//         int visited[] = new int[n+1];
//         // int maxs=0;

//         for(int i=0;i<n+1;i++)
//             adj.add(new ArrayList<>());
//         for(int i=0;i<edges.length;i++)
//         {
//             int u = edges[i][0];
//             int v = edges[i][1];

//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }

//         for(int i=1;i<n+1;i++)
//         {
//             if(visited[i]==0)
//             {
//                 if(check(i,1,-1,visited,adj)==true)
//                     return -1;
//             }
//         }
//         return maxs+1;
//     }
//     public boolean check(int nodez,int s,int parent, int visited[],ArrayList<ArrayList<Integer>> adj)
//     {
//         Queue<int[]>q = new LinkedList<>();
//         q.offer(new int[]{nodez,s,parent});
//         while(!q.isEmpty())
//         {
//             int pop[] = q.poll();
//             int node = pop[0];
//             int steps = pop[1];
//             int par = pop[2];

//             maxs = Math.max(maxs,steps);
//             visited[node]=1;
//             for(int it:adj.get(node))
//             {
//                 if(visited[it]==0)
//                 {
//                     q.offer(new int[]{it,steps+1,node});
//                 }
//                 else if(visited[it]==1 && it!=par)
//                 {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Adjacency list to represent the graph
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
                    return -1; // Graph is not bipartite
                }
                result += getMaxGroups(component, adj);
            }
        }

        return result;
    }

    // Check if the graph is bipartite and collect nodes in the connected component
    private boolean isBipartite(int start, ArrayList<ArrayList<Integer>> adj, int[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1; // Start with group 1
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = -visited[node]; // Alternate group
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

    // Get the maximum number of groups for a connected component
    private int getMaxGroups(List<Integer> component, ArrayList<ArrayList<Integer>> adj) {
        int maxGroups = 0;

        for (int node : component) {
            maxGroups = Math.max(maxGroups, bfsDepth(node, adj));
        }

        return maxGroups;
    }

    // Perform BFS and calculate depth
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
