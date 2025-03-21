class Solution 
{
    public String longestPalindrome(String s) 
    {
        if(s.length()==1)
            return s;
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String t = new String(sb.toString());
        // sb.clear();
        int last_i=0,last_j=0;
        int n = s.length(),maxi=Integer.MIN_VALUE;
        int dp[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=0;
                }
                if(maxi<dp[i][j] && i - dp[i][j] == n - j)
                {
                    maxi = dp[i][j];
                    last_i = i;
                }
            }
        }
        return s.substring(last_i - maxi, last_i);
    }
}