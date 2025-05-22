class Solution 
{
    public int minDistance(String s1, String s2) 
    {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0] = i;
        }
        for(int j=0;j<=n;j++)
        {
            dp[0][j] = j;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                {
                    int insert = dp[i][j-1];
                    int update = dp[i-1][j-1];
                    int delete = dp[i-1][j];
                    dp[i][j] = 1+Math.min(insert,Math.min(update,delete));
                }
            }
        }
        return dp[m][n];
    }
    public int f(String s1,String s2,int i,int j)
    {
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;

        if(s1.charAt(i)==s2.charAt(j))
            return f(s1,s2,i-1,j-1);
        return 1+Math.min(f(s1,s2,i-1,j-1),Math.min(f(s1,s2,i-1,j),f(s1,s2,i,j-1)));
    }
}