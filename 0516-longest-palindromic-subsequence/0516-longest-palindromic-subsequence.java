class Solution 
{
    public int longestPalindromeSubseq(String text1) 
    {
        StringBuilder sb = new StringBuilder(text1);
        sb.reverse();
        String text2 = sb.toString();
        int m = text1.length(), n=text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}