class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                    dp[i][j] = 0;

                else if(i==0 && j==0)
                    dp[i][j] = 1;
                else
                {
                    if(i-1>=0)
                        dp[i][j]+=dp[i-1][j];
                    if(j-1>=0)
                        dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int f(int m,int n,int grid[][])
    {
        if(m<0 || n<0)
            return 0;

        if(m==0 && n==0)
            return 1;
        
        if(grid[m][n]==1)
            return 0;

        return f(m-1,n,grid)+f(m,n-1,grid);
    }
}