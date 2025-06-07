class Solution 
{
    public int countSquares(int[][] mat) 
    {
        int m = mat.length,n=mat[0].length,sum=0;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0] = mat[i][0];
        for(int j=0;j<n;j++)
            dp[0][j] = mat[0][j];

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(mat[i][j]==1)
                {
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}