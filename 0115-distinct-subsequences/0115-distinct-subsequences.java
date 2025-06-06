class Solution 
{
    public int numDistinct(String text1, String text2) 
    {
        int m = text1.length(), n=text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0] = 1;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}