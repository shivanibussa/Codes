class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[0][j] = j/coins[0];
            else
                dp[0][j] = (int)1e9;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int take = (int)1e9;
                int not_take = 0+dp[i-1][j];
                if(coins[i]<=j)
                    take = 1+dp[i][j-coins[i]];

                dp[i][j] = Math.min(take,not_take);
            }
        }
        int res = dp[n-1][amount];
        return res==(int)1e9 ? -1:res;
    }
    public int f(int coins[],int amount,int ind)
    {
        if(ind==0)
        {
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return (int)1e9;
        }
        int take = (int)1e9;
        int not_take = 0+f(coins,amount,ind-1);
        if(coins[ind]<=amount)
            take = 1+f(coins,amount-coins[ind],ind);

        return Math.min(take,not_take);
    }
}