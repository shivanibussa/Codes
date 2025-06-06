class Solution 
{
    public boolean isMatch(String s1, String s2) 
    {
        int m = s1.length(), n = s2.length();
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=m;i++)
        {
            dp[i][0]=false;
        }
        for(int j=1;j<=n;j++)
        {
            boolean flag=true;
            for(int ii=j;ii>0;ii--)
            {
                if(s2.charAt(ii-1)!='*')
                {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(s2.charAt(j-1)=='*')
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}