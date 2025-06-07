class Solution 
{
    public int longestStrChain(String[] arr) 
    {
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        int n = arr.length,maxL=1,end=0;
        int dp[] = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(Check(arr[i],arr[j]) && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
            }
            if(maxL<dp[i])
            {
                maxL = dp[i];
                end = i;
            }
        }        
        return maxL;
    }
    public boolean Check(String s,String t)
    {
        int i=0,m=s.length(),j=0,n=t.length();
        if(m-n!=1)
            return false;
        while(i<m)
        {
            if(j<n && s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(i==m && j==n)
            return true;
        return false;
    }
}