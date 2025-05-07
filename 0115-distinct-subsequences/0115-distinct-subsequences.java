class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int m = s.length(), n=t.length();
        int dp[][] = new int[m+1][n+1];
        
        for(int j=0;j<n+1;j++)
        {
            dp[0][j] = 0;
        }
        for(int i=0;i<m+1;i++)
        {
            dp[i][0] = 1;
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    public int f(String s, String t,int i,int j,int m,int n)
    {
        if(j<0)
            return 1;
        if(i<0)
            return 0;

        if(s.charAt(i)==t.charAt(j))
        {
            return f(s,t,i-1,j-1,m,n)+f(s,t,i-1,j,m,n);
        }
        return f(s,t,i-1,j,m,n);
    }
}