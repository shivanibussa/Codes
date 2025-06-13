class Solution 
{
    public String shortestCommonSupersequence(String text1, String text2) 
    {
        int m = text1.length(), n=text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i =m,j=n;
        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0)
        {
            if(text1.charAt(i-1)==text2.charAt(j-1))
            {
                sb.append(text1.charAt(i-1));
                i=i-1;
                j=j-1;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                sb.append(text1.charAt(i-1));
                i=i-1;
            }
            else
            {
                sb.append(text2.charAt(j-1));
                j=j-1;
            }
        }
        while(i>0)
        {
            sb.append(text1.charAt(i-1));
            i=i-1;
        }
        while(j>0)
        {
            sb.append(text2.charAt(j-1));
                j=j-1;
        }
        sb.reverse();
        return sb.toString();
    }
    
}