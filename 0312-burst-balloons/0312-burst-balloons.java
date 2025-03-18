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
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return f(1,n,newNums,dp);
    }
    int f (int i,int j,int []nums, int [][]dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int maxP = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int points = nums[i-1]*nums[k]*nums[j+1] + f(i,k-1,nums,dp)+f(k+1,j,nums,dp);
            maxP = Math.max(maxP,points);
        }
        return dp[i][j]=maxP;
    }
}