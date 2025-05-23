class Solution 
{
    public int findNumberOfLIS(int[] arr) 
    {
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        int maxi=1,cnts=0;

        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            count[i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    count[i] = count[j];
                }
                else if(arr[i]>arr[j] && 1+dp[j]==dp[i])
                {
                    count[i]+=count[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(dp[i]==maxi)
                cnts+=count[i];
        }
        return cnts;
    }
}