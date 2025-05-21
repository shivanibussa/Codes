class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
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
                    if(i-1>=0)
                        dp[i][j]+=dp[i-1][j];
                    if(j-1>=0)
                        dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int f(int m,int n)
    {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;

        return f(m-1,n)+f(m,n-1);
    }
}