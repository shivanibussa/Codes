class Solution 
{
    public int findNumberOfLIS(int[] arr) 
    {
        int n = arr.length,maxi=1;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        int cnts=0;
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && dp[j]+1>dp[i])
                {
                    dp[i] = 1+dp[j];
                    cnt[i] = cnt[j];
                }
                else if(arr[i]>arr[j] && dp[j]+1==dp[i])
                {
                    cnt[i]+=cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(dp[i]==maxi)
            {
                cnts+=cnt[i];
            }
        }
        return cnts;

    }
}