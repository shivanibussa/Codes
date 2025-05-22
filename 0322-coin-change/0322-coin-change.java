class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[] = new int[amount+1];
        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
            {
                dp[j] = j/coins[0];
            }
            else
            {
                dp[j] = (int)1e9;
            }
        }
        for(int i=1;i<n;i++)
        {
            int temp[] = new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int take = (int)1e9;
                int not_take = dp[j];
                if(coins[i]<=j)
                    take = 1+temp[j-coins[i]];

                temp[j] = Math.min(take,not_take);
            }
            dp=temp;
        }
        return dp[amount]==(int)1e9 ? -1 : dp[amount];
    }
}