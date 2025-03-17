class Solution 
{
    public int findNumberOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n+1];
        int counts[] = new int[n+1];
        int maxCount=0,maxi=1;
        for(int i=0;i<n;i++){
            dp[i]=1;counts[i]=1;
            }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i])
                    {
                        dp[i] = 1+dp[j];
                        counts[i]=counts[j];
                    }
                    else if(dp[j]+1==dp[i])
                    {
                        counts[i]+=counts[j];
                    }
                    
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        for(int i=0;i<n;i++)
            if(maxi==dp[i])
                maxCount+=counts[i];
        return maxCount;
    }
}