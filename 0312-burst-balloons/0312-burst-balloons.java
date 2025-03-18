class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n = nums.length;
        int newNums[] = new int[n+2];
        System.arraycopy(nums, 0, newNums, 1, n);
        int nc = newNums.length;
        newNums[0]=1;
        newNums[nc-1]=1;
        int dp[][] = new int[n+2][n+2];
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=n;j++)
            {
                if(i>j)
                    continue;
                int maxP = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int points = newNums[i-1]*newNums[k]*newNums[j+1] + dp[i][k-1]+dp[k+1][j];
                    maxP = Math.max(maxP,points);
                }
                dp[i][j] = maxP;
            }
        }
        return dp[1][n];
    }
}