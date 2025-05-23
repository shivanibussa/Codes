class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] arr) 
    {
        Arrays.sort(arr);
        int n = arr.length,lastindex=0,maxi=1;
        int dp[] = new int[n];
        int hash[] = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            dp[i] = 1;
            hash[i] = i;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(maxi<dp[i])
            {
                maxi = dp[i];
                lastindex = i;
            }
        }
        res.add(arr[lastindex]);
        while(lastindex!=hash[lastindex])
        {
            lastindex = hash[lastindex];
            res.add(arr[lastindex]);
        }
        Collections.reverse(res);
        return res;
    }
    
}