class DisjointSet
{
    ArrayList<Integer> parent;
    ArrayList<Integer> size;
    public DisjointSet(int V)
    {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int getUparent(int node)
    {
        if(node==parent.get(node))
            return node;
        int ulp_u = getUparent(parent.get(node));
        parent.set(node,ulp_u);
        return parent.get(node);
    }
    public void unionBySize(int u,int v)
    {
        int ulp_u = getUparent(u);
        int ulp_v = getUparent(v);
        if(ulp_u==ulp_v)
            return;
        if(size.get(ulp_u)>size.get(ulp_v))
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

class Solution 
{
    public int largestIsland(int[][] grid) 
    {
        
        int m = grid.length, n = grid[0].length;
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        DisjointSet ds = new DisjointSet(m*n);
        int ans = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                    continue;
                for(int k=0;k<4;k++)
                {
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                        int neighN = nr*n+nc;
                        int node = i*n+j;
                        ds.unionBySize(node,neighN);
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    continue;
                HashSet<Integer> hs = new HashSet<>();
                for(int k=0;k<4;k++)
                {
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                        int neighN = nr*n+nc;
                        hs.add(ds.getUparent(neighN));
                    }
                }
                int Tsize = 0;
                for(Integer it:hs)
                {
                    Tsize+=ds.size.get(it);
                }
                ans = Math.max(ans,Tsize+1);
            }
        }
        for(int i=0;i<m*n;i++)
        {
            ans = Math.max(ans,ds.size.get(ds.getUparent(i)));
        }
        return ans;
    }
}