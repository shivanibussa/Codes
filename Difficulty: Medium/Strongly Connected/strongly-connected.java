class Solution 
{
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        int V = adj.size();
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int cnt=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,adj,visited,st);
            }
        }
        for(int i=0;i<V;i++)
        {
            adjRev.add(new ArrayList<>());
            visited[i]=0;
        }
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                adjRev.get(it).add(i);
            }
        }
        while(!st.isEmpty())
        {
            int pop = st.pop();
            if(visited[pop]==0)
            {
                cnt++;
                dfs2(pop,adjRev,visited);
            }
        }
        return cnt;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int visited[],Stack<Integer> st)
    {
        visited[node] = 1;
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                dfs(it,adj,visited,st);
            }
        }
        st.push(node);
    }
    public void dfs2(int node,ArrayList<ArrayList<Integer>> adj,int visited[])
    {
        visited[node] = 1;
        for(int it:adj.get(node))
        {
            if(visited[it]==0)
            {
                dfs2(it,adj,visited);
            }
        }
    }
    
}