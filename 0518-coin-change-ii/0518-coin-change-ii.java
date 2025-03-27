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
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int not_take = dp[i-1][j];
                int take = 0;
                if(coins[i]<=j)
                    take = dp[i][j-coins[i]];

                dp[i][j] = take+not_take;
            }
        }
        return dp[n-1][amount];
    }
}
