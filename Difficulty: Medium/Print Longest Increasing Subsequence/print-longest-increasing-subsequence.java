class Solution 
{
    public ArrayList<Integer> getLIS(int arr[])
    {
        int n = arr.length,maxL=1,end=0;
        int hash[] = new int[n];
        int dp[] = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    hash[i] =j;
                }
            }
            if(maxL<dp[i])
            {
                maxL = dp[i];
                end = i;
            }
        }        
        res.add(arr[end]);
        while(hash[end]!=end)
        {
            end=hash[end];
            res.add(arr[end]);
        }
        Collections.reverse(res);
        return res;
    }
}
