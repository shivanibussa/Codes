class Solution 
{
    public int minCut(String s) 
    {
        int n = s.length();
        int dp[] = new int[n+1];
        for(int i=0;i<n;i++)
            dp[i]=-1;
        return f(0,s,dp)-1;
    }
    public int f(int i,String s,int[] dp)
    {
        int n = s.length();
        if(dp[i]!=-1)
            return dp[i];
        if(i>=n)
            return 0;
        int minCuts = Integer.MAX_VALUE;
        for(int j=i;j<n;j++)
        {
            if(isPalindrome(i,j,s)==true){
                int ways = 1+f(j+1,s,dp);
                minCuts = Math.min(minCuts,ways);
            }
        }
        return dp[i] = minCuts;
    }
    boolean isPalindrome(int f,int s,String str)
    {
        while(f<s)
        {
            if(str.charAt(f)!=str.charAt(s))
               return false;
            f++;
            s--;
            
        }
        return true;
    }
}