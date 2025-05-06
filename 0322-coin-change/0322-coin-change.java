class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[] = new int[amount+1];
        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[j] = j/coins[0];
            else
                dp[j] = (int)1e8;
        }
        for(int i=1;i<n;i++)
        {
            int temp[] = new int[amount+1];
            for(int j = 0;j<=amount;j++)
            {
                int not_take = dp[j];
                int take = (int)1e8;
                if(j>=coins[i])
                    take = 1+temp[j-coins[i]];

                temp[j] = Math.min(take,not_take);
            }
            dp = temp;
        }
        return dp[amount] ==(int)1e8 ? -1: dp[amount];
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