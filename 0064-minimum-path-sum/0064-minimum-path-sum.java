class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m=grid.length,n=grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    dp[i][j]=grid[0][0];
                else
                {
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    if(i-1>=0)
                        up = grid[i][j]+dp[i-1][j];
                    if(j-1>=0)
                        left = grid[i][j]+dp[i][j-1];
                    
                dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int f(int grid[][],int i,int j)
    {
        if(i==0 && j==0)
            return grid[i][j];
        int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
        if(i-1>=0)
            up = grid[i][j]+f(grid,i-1,j);
        if(j-1>=0)
            left = grid[i][j]+f(grid,i,j-1);

        return Math.min(up,left); 
    }
}