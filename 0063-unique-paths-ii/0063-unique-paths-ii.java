class Solution 
{
    public int uniquePathsWithObstacles(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    temp[j]=0;
                else if(i==0 && j==0)
                    temp[j]=1;
                else
                {
                    int up = 0;
                    int left = 0;
                    if(i>0)
                        up = dp[j];
                    if(j>0)
                        left =temp[j-1];
                    
                    temp[j] = up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}