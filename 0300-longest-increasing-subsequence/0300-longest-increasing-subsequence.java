class Solution 
{
    public int lengthOfLIS(int[] arr) 
    {
        int n = arr.length,maxL=1;
        int cnt[] = new int[n];
        for(int i=0;i<n;i++)
            cnt[i] = 1;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                    cnt[i] = Math.max(cnt[i],cnt[j]+1);
            }
            maxL = Math.max(maxL,cnt[i]);
        }        
        return maxL;
    }
}