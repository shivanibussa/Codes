class Solution 
{
    public int rob(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++)
        {
            int not_take = 0+dp[i-1];
            int take = nums[i];
            if(i>1)
                take += dp[i-2];
            dp[i] = Math.max(take,not_take);
        }
        return dp[n-1];
    }
    public int f(int nums[],int n)
    {
        if(n==0)
            return nums[0];
        if(n<0)
            return 0;
        int not_take = 0+f(nums,n-1);
        int take = nums[n]+f(nums,n-2);

        return Math.max(take,not_take);
    }
}