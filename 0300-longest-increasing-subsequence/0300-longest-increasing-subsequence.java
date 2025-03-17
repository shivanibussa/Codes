class Solution
{
    public int lengthOfLIS(int[] arr) 
    {
        int n = arr.length;
        int dp[] = new int[n];
        int maxi=1;
        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}