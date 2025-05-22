class Solution 
{
    public int longestCommonSubsequence(String s1, String s2) 
    {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int f(String s1, String s2, int i,int j)
    {
        if(i<0 || j<0)
            return 0;
        
        if(s1.charAt(i)==s2.charAt(j))
        {
            return 1+f(s1,s2,i-1,j-1);
        }
        return Math.max(f(s1,s2,i-1,j),f(s1,s2,i,j-1));
    }
}