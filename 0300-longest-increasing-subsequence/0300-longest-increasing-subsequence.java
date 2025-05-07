class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n],maxi=1;
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
            if(nums[i]>nums[j])
                dp[i] = Math.max(dp[i],1+dp[j]);
            }
            maxi = Math.max(dp[i],maxi);
        }
        return maxi;
    }
}