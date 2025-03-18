class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] arr) 
    {
        int n = arr.length,lastIndex=0;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int maxi=1;
        for(int i=0;i<n;i++)
        {
            dp[i]=1;
            hash[i]=i;
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j] == 0 && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                    
                }
            }
            if(dp[i]>maxi)
            {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[lastIndex]);

        while(lastIndex != hash[lastIndex])
        {
            lastIndex = hash[lastIndex];
            res.add(arr[lastIndex]);
        }
    return res;
    }
}