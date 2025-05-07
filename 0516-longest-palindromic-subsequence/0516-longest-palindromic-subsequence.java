class Solution 
{
    public int longestPalindromeSubseq(String s) 
    {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String text2 = sb.toString();
        int m = s.length(), n=text2.length();
        int dp[] = new int[n+1];
        for(int i=1;i<m+1;i++)
        {
            int temp[] = new int[n+1];
            for(int j=1;j<n+1;j++)
            {
                if(s.charAt(i-1)==text2.charAt(j-1))
                    temp[j] = 1+dp[j-1];

                else
                    temp[j] = Math.max(dp[j],temp[j-1]);
            }
            dp = temp;
        }
        return dp[n];
    }
}