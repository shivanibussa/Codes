class Solution 
{
    public int minCut(String s) 
    {
        int n = s.length();
        int dp[] = new int[n+2];
        for(int i=n-1;i>=0;i--)
        {
            int minCuts = Integer.MAX_VALUE;
            for(int j=i;j<n;j++)
            {
                if(isPalindrome(i,j,s)==true){
                    int ways = 1+dp[j+1];
                    minCuts = Math.min(minCuts,ways);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0]-1;
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