class Solution 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        return f(0,arr,k,dp);
    }
    public int f(int i,int[] arr,int k,int[] dp)
    {
        int n = arr.length;
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int maxSum=Integer.MIN_VALUE;
        int len=0,maxi=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+k,n);j++)
        {
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = len*maxi+f(j+1,arr,k,dp);
            maxSum = Math.max(maxSum,sum);
        }
        return dp[i] = maxSum;
    }
}