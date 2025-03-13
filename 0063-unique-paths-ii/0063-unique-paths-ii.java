class Solution 
{
    public int uniquePathsWithObstacles(int[][] grid) 
    {
        if (grid[0][0] == 1) return 0;

        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(grid[i][j]==1)
                {
                    dp[i][j] = 0;
                }
                else if(i==0 && j==0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    int left = 0,up=0;
                    if(j>0)
                        left = dp[i][j-1];
                    if(i>0)
                        up = dp[i-1][j];

                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}