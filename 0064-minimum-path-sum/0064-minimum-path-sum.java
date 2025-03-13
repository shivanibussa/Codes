class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int n = grid.length, m=grid[0].length;
        int dp[] = new int[m];
        for(int i=0;i<n;i++)
        {
            int temp[] = new int[m];
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                    temp[j] = grid[i][j];
                else
                {
                    int up=grid[i][j],left=grid[i][j];
                    if(i>0)
                        up+=dp[j];
                    else
                        up=Integer.MAX_VALUE;
                    if(j>0)
                        left+=temp[j-1];
                    else
                        left = Integer.MAX_VALUE;

                    temp[j] = Math.min(up,left);
                }
            }
            dp=temp;
        }
        return dp[m-1];
    }
}