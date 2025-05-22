class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int m=s.length(), n=t.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++)
        {
            int temp[] = new int[n+1];
            temp[0] = 1;
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                    temp[j] = dp[j-1]+dp[j];
                else
                    temp[j] = dp[j];
            }
            dp = temp;
        }
        return dp[n];
    }
    public int f(String s1, String s2, int i,int j)
    {
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(s1.charAt(i)==s2.charAt(j))
            return f(s1,s2,i-1,j-1)+f(s1,s2,i-1,j);
        return f(s1,s2,i-1,j);
    }
}