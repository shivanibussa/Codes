class Solution 
{
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i-1;j>=-1;j--)
            {
                int take = Integer.MIN_VALUE;
                int not_take = dp[i+1][j+1];
                if(j==-1 || nums[i]>nums[j])
                    take = 1+dp[i+1][i+1];

                dp[i][j+1] = Math.max(take,not_take);
            }
        }
        return dp[0][0];
    }
    public int f(int nums[],int ind,int prev)
    {
        if(ind==nums.length)
            return 0;

        int not_take = f(nums,ind+1,prev);
        int take = Integer.MIN_VALUE;
        if(prev==-1 || nums[ind]>nums[prev])
            take = 1+f(nums,ind+1,ind);

        return Math.max(not_take,take);
    }
}