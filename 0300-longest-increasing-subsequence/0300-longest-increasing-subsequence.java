class Solution
{
    public int lengthOfLIS(int[] arr) 
    {
        int n = arr.length;
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i-1;j>=-1;j--)
            {
                int len = 0+dp[i+1][j+1];
                if(j==-1 || arr[i]>arr[j])
                    len = Math.max(len,1+dp[i+1][i+1]);

                dp[i][j+1] = len;

            }
        }
        return dp[0][0];
    }
}