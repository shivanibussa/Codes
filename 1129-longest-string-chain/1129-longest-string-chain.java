class Solution 
{
    public int longestStrChain(String[] words) 
    {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int maxi=1;
        int n = words.length;
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
            dp[i] = 1;
            for(int j=0;j<i;j++)
            {
                if(compare(words[i],words[j]) && 1+dp[j]>dp[i])
                {
                    dp[i] = 1+dp[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public boolean compare(String s1, String s2) 
    {
        if(s1.length()!=s2.length()+1)
            return false;

        int f=0,s=0;
        while(f<s1.length())
        {
            if(s<s2.length()&& s1.charAt(f)==s2.charAt(s))
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