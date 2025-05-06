class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    int up=0,left=0;
                    if(i>0)
                        up = dp[i-1][j];
                    if(j>0)
                        left = dp[i][j-1];

                    dp[i][j] = up+left;
                }

            }
        }
        return dp[m-1][n-1];
    }
    public int f(int i,int j)
    {
        if(i==0 && j==0)
            return 1;
        int up=0,left=0;
        if(i>0)
            up = f(i-1,j);
        if(j>0)
            left = f(i,j-1);

        return up+left;
    }
}