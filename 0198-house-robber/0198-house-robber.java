class Solution 
{
    public int rob(int[] nums) 
    {
        int n=nums.length;
        int dp[] = new int[n];
        dp[0]=nums[0];

        for(int i=1;i<n;i++)
        {
            int take = nums[i];
            int not_take = 0+dp[i-1];
            if(i-2>=0)
                take+=dp[i-2];

            dp[i] = Math.max(take,not_take);
        }
        return dp[n-1];
    }
    public int f(int i,int nums[])
    {
        if(i==0)
            return nums[i];

        int take = nums[i];
        int not_take = 0+f(i-1,nums);
        if(i-2>=0)
            take+=f(i-2,nums);
        
        return Math.max(take,not_take);
    }
}