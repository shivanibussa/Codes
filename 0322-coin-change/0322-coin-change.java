class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int dp[] = new int[amount+1];
        for(int T=0;T<=amount;T++)
        {
            if(T%coins[0]==0)
                dp[T] = (T/coins[0]);
            else 
                dp[T] = (int)1e+8;
        }
        for(int i=1;i<n;i++)
        {
            int temp[] = new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int not_take = dp[j];
                int take =(int)1e+8;
                if(j>=coins[i])
                    take = 1+temp[j-coins[i]];

                temp[j] = Math.min(take,not_take);
            }
            dp=temp;
        }
        return dp[amount]!=(int)1e+8?dp[amount]:-1;
    }
}