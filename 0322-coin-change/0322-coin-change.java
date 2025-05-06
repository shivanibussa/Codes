class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[0][j] = j/coins[0];
            else
                dp[0][j] = (int)1e8;
        }
        for(int i=1;i<n;i++)
        {
            for(int j = 0;j<=amount;j++)
            {
                int not_take = dp[i-1][j];
                int take = (int)1e8;
                if(j>=coins[i])
                    take = 1+dp[i][j-coins[i]];

                dp[i][j] = Math.min(take,not_take);
            }
        }
        return dp[n-1][amount] ==(int)1e8 ? -1: dp[n-1][amount];
    }
    int f(int coins[],int amount,int ind)
    {
        if(ind==0)
        {
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return (int)1e8;
        }
        int not_take = f(coins,amount,ind-1);
        int take = Integer.MAX_VALUE;
        if(amount>=coins[ind])
            take = 1+f(coins,amount-coins[ind],ind);

        return Math.min(take,not_take);
    }
}