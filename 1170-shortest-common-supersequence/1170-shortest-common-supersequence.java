class Solution 
{
    public String shortestCommonSupersequence(String str1, String str2) 
    {
        int s1 = str1.length(),s2 = str2.length();
        int dp[][] = new int[s1+1][s2+1];
        for(int i=1;i<=s1;i++)
        {
            for(int j=1;j<=s2;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=s1,j=s2;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                sb.append(str1.charAt(i-1));
                i--;
            }
            else
            {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        String ans = new String(sb.reverse());
        return ans;
    }
}