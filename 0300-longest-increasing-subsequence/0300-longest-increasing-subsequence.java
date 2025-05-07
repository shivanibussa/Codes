class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int temp[] = new int[n+1];
            for(int j=i-1;j>=-1;j--)
            {
                int len=0;
                len = 0+dp[j+1];
                if(j==-1 || nums[i]>nums[j])
                    len = Math.max(len,1+dp[i+1]);

                temp[j+1] = len;
            }
            dp = temp;
        }        
        return dp[0];
    }
}