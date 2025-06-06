class Solution 
{
    public int change(int amount, int[] coins) 
    {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        dp[0][0]=1;
        for(int j=1;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int take = 0;
                int not_take = 0+dp[i-1][j];
                if(coins[i]<=j)
                    take = dp[i][j-coins[i]];

                dp[i][j] = take+not_take;
            }
        }
        int res = dp[n-1][amount];
        return res;
    }
}