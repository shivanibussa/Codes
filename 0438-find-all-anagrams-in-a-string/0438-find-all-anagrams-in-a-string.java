class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        int f1[] = new int[26];
        int f2[] = new int[26];
        int matches=0;
        List<Integer> res = new ArrayList<>();
        
        if(p.length()>s.length())
            return res;
        for(int i=0;i<p.length();i++)
        {
            f1[s.charAt(i)-'a']++;
            f2[p.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(f1[i]==f2[i])
                matches++;
        }
        if(matches==26)
            {
                res.add(0);
            }
        int l=0;
        for(int r=p.length();r<s.length();r++)
        {
            
            int index = s.charAt(r)-'a';
            f1[index]++;

            if(f1[index]==f2[index])
                matches++;
            else if(f2[index]+1==f1[index])
                matches--;

            index = s.charAt(l)-'a';
            f1[index]--;
            if(f2[index]==f1[index])
                matches++;
            else if(f2[index]-1==f1[index])
                matches--;
            
            
            l++;
            if(matches==26){
                res.add(l);
            }
        }
        return res;
    }
}