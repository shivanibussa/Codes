class Solution 
{
    public boolean canFinish(int N, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int p = prerequisites.length;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p;i++)
        {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        int inorder[] = new int[N];
        for(int i=0;i<N;i++)
        {
            for(int it:adj.get(i))
            {
                inorder[it]++;
            }
        }
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
            res.add(pop);
            for(int it:adj.get(pop))
            {
                inorder[it]--;
                if(inorder[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        return res.size()==N;
    }
}