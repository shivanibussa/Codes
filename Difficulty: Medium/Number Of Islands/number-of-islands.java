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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) 
    {
        DisjointSet ds = new DisjointSet(rows*cols);
        int visited[][] = new int[rows][cols];
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;
        int n = operators.length;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        for(int i=0;i<n;i++)
        {
            int a = operators[i][0];
            int b = operators[i][1];
            if(visited[a][b]==1){
                ans.add(cnt);
                continue;
            }
                
                
            visited[a][b] = 1;
            cnt++;
            for(int k=0;k<4;k++)
            {
                int nr = a+dr[k];
                int nc = b+dc[k];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && visited[nr][nc]==1)
                {
                    int neighN = nr*cols+nc;
                    int node = a*cols+b;
                    if(ds.getUparent(neighN)!=ds.getUparent(node))
                    {
                        cnt--;
                        ds.unionBySize(neighN,node);
                        
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}