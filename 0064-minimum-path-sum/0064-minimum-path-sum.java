class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = grid[i][j];
                else
                {
                    int up = Integer.MAX_VALUE,left = Integer.MAX_VALUE;
                    if(i-1>=0)
                        up = dp[i-1][j];
                    if(j-1>=0)
                        left = dp[i][j-1];

                    dp[i][j] = grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int f(int grid[][],int m,int n)
    {
        if(m==0 && n==0)
            return grid[m][n];

        if(m<0 || n<0)
            return Integer.MAX_VALUE;

        return grid[m][n]+Math.min(f(grid,m-1,n),f(grid,m,n-1));
    }
}