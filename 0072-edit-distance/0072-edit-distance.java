class Solution 
{
    public int minDistance(String s1, String s2) 
    {
        int m =s1.length(),n=s2.length();
        int dp[] = new int[n+1];
        for(int j=0;j<=n;j++)
            dp[j] = j;
        for(int i=1;i<=m;i++)
        {
            int temp[] = new int[n+1];
            temp[0] = i;
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    temp[j] = dp[j-1];
                }
                else
                {
                    int insertions = temp[j-1];
                    int deletion = dp[j];
                    int replace = dp[j-1];
                    temp[j] = 1+Math.min(Math.min(insertions,deletion),replace);
                }
            }
            dp=temp;
        }
        return dp[n];
    }
}