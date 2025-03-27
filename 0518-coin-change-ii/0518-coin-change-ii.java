class Solution 
{
    public int change(int amount, int[] coins) 
    {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        
        dp[0] = 1; // Base case: One way to make amount 0 (using no coins)

        for (int i = 0; i < n; i++) 
        {
            for (int j = coins[i]; j <= amount; j++) 
            {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
