class Solution 
{
    public int numDistinct(String s, String t) 
    {
        int m = s.length(),n=t.length();
        int dp[] = new int[n+1];
        // for(int i=0;i<=m;i++)
            dp[0]=1;
        for(int i=1;i<=m;i++)
        {
            // int temp[] = new int[n+1];
            // temp[0]=1;
            for(int j=n;j>0;j--)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[j] = dp[j-1]+dp[j];
                }
                else
                {
                    dp[j] = dp[j];
                }
            }
            // dp=temp;
        }
        return dp[n];
    }
}