class Solution 
{
    public boolean isMatch(String text, String pattern) 
    {
        int m = pattern.length(), n=text.length();
		boolean dp[][] = new boolean[m+1][n+1];
		dp[0][0] = true;
		for(int j=1;j<=n;j++)
			dp[0][j] = false;

		for(int i=1;i<=m;i++)
		{
			boolean flag = true;
			for(int ii=1;ii<=i;ii++)
			{
				if(pattern.charAt(ii-1)!='*')
				{
					flag = false;
					break;
				}
			}
			dp[i][0] = flag;
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?')
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else if(pattern.charAt(i-1)=='*')
				{
					dp[i][j] = dp[i][j-1] | dp[i-1][j];
				}
				else
				{
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
    }
}