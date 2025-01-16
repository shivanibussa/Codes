class Solution 
{
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = graph.length;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int inorder[] = new int[N];

        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(graph[i][j]).add(i);
                inorder[i]++;
            }
        }
        
        // for(int i=0;i<N;i++)
        // {
        //     for(int it:adj.get(i))
        //     {
        //         inorder[it]++;
        //     }
        // }
        for(int i=0;i<N;i++)
        {
            if(inorder[i]==0)
            {
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int pop = q.poll();
            arr.add(pop);
            for(int it:adj.get(pop))
            {
                inorder[it]--;
                if(inorder[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        Collections.sort(arr);
        return arr;
    }
}