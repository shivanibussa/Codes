class Solution 
{
    public int longestStrChain(String[] s) 
    {
        Arrays.sort(s,(a,b)->a.length()-b.length());
        int n = s.length,maxi=1;
        int dp[] = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(Check(s[i],s[j]) && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
                maxi = Math.max(maxi,dp[i]);
            }
        }       
        return maxi;
    }
    boolean Check(String s1, String s2)
    {
        int f=0,s=0,m=s1.length(),n=s2.length();
        if(m-n!=1)
            return false;
        while(f<m)
        {
            if(s<n && s1.charAt(f)==s2.charAt(s))
            {
                f++;
                s++;
            }
            else
            {
                f++;
            }
        }
        if(f==s1.length() && s==s2.length())
            return true;
        return false;
    }
}