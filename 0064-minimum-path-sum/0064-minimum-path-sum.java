class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    temp[j] = grid[i][j];
                else
                {
                    int up = Integer.MAX_VALUE,left = Integer.MAX_VALUE;
                    if(i-1>=0)
                        up = dp[j];
                    if(j-1>=0)
                        left = temp[j-1];

                    temp[j] = grid[i][j]+Math.min(up,left);
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}