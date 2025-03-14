class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int T=0;T<=amount;T++)
        {
            if(T%coins[0]==0)
                dp[0][T] = (T/coins[0]);
            else 
                dp[0][T] = (int)1e+8;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int not_take = dp[i-1][j];
                int take =(int)1e+8;
                if(j>=coins[i])
                    take = 1+dp[i][j-coins[i]];

                dp[i][j] = Math.min(take,not_take);
            }
        }
        return dp[n-1][amount]!=(int)1e+8?dp[n-1][amount]:-1;
    }
}