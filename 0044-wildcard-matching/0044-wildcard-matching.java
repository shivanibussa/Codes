class Solution 
{
    public boolean isMatch(String s, String p) 
    {
        int m = s.length(),n=p.length();
        boolean dp[][] = new boolean[m+1][n+1]; 
        dp[0][0] = true; // Both strings are empty

        // Initialize dp[0][j] for pattern p
        for (int j = 1; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }

        // Initialize dp[i][0] for string s
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false; // Non-empty string can't match empty pattern
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}