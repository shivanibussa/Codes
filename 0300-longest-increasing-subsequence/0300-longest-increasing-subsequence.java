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
                int len = 0+dp[i+1][j+1];
                if(j== -1 || nums[i]>nums[j])
                {
                    len = Math.max(len,1+dp[i+1][i+1]);
                }
                dp[i][j+1] = len;
            }
        }
        return dp[0][0];
    }
    public int f(int nums[],int i,int prev_ind, int n)
    {
        if(i==n)
            return 0;

        int len=0;
        len = 0+f(nums,i+1,prev_ind,n);
        if(prev_ind==-1 || nums[i]>nums[prev_ind])
            len = Math.max(len,1+f(nums,i+1,i,n));

        return len;
    }
}