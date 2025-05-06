class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        for(int j=0;j<=amount;j++)
        {
            if(j%coins[0]==0)
                dp[j] = 1;
            else
                dp[j] = 0;
        }
        for(int i=1;i<n;i++)
        {
            int temp[] = new int[amount+1];
            for(int j = 0;j<=amount;j++)
            {
                int not_take = dp[j];
                int take = 0;
                if(j>=coins[i])
                    take = temp[j-coins[i]];

                temp[j] = take+not_take;
            }
            dp = temp;
        }
        return dp[amount];
    }
}