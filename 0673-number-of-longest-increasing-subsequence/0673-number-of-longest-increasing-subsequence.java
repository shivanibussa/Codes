class Solution 
{
    public int findNumberOfLIS(int[] arr) 
    {
        int n = arr.length,maxL=1,res=0;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        for(int i=0;i<n;i++){
            cnt[i] = 1;
            dp[i]=1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && 1+dp[j]>dp[i]){
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j];
                }
                else if(arr[i]>arr[j] && 1+dp[j]==dp[i])
                {
                    cnt[i]+=cnt[j];
                }
            }
            maxL = Math.max(maxL,dp[i]);
        }  

        for(int i=0;i<n;i++)
        {
            if(maxL==dp[i])
                res+=cnt[i];
        }

        return res;
    }
}