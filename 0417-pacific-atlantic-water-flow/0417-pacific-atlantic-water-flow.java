class Solution 
{
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int n = heights[0].length,m=heights.length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            dfs(i,0,heights,pacific);
            dfs(i,n-1,heights,atlantic);
        }

        for(int j=0;j<n;j++)
        {
            dfs(0,j,heights,pacific);
            dfs(m-1,j,heights,atlantic);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pacific[i][j]&&atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public void dfs(int r,int c,int heights[][],boolean visited[][])
    {
        visited[r][c]=true;
        int rows = heights.length,cols=heights[0].length;
        int dr[] = new int[]{-1,0,1,0};
        int dc[] = new int[]{0,-1,0,1};
        for(int k=0;k<4;k++)
        {
            int nr = r+dr[k];
            int nc = c+dc[k];

            if(nr>=0 && nr<rows && nc>=0 && nc<cols && !visited[nr][nc] && heights[r][c]<=heights[nr][nc])
            {
                dfs(nr,nc,heights,visited);
            }
        }
    }
}