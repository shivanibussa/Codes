class Solution 
{
    public boolean canConstruct(String s, int k) 
    {
        if(s.length()<k)
            return false;
        int fre[] = new int[26];
        int c=0;
        for(char ch:s.toCharArray())
        {
            fre[ch-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(fre[i]%2==1)
                c++;
        }
        return c<=k;
    }
}