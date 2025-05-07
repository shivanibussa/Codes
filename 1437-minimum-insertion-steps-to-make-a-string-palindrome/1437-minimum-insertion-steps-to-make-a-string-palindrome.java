class Solution 
{
    public int minInsertions(String s) 
    {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String t = sb.toString();
        int m = s.length() , n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[m][n];
    }
}