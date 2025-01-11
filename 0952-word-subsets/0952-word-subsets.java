class Solution
{
    public List<String> wordSubsets(String[] A, String[] B) 
    {
        int target[] = new int[26];
        ArrayList<String> res=new ArrayList<>();
        for(String b:B)
        {
            int temp[] = new int[26];

            for(char c:b.toCharArray())
            {
                temp[c-'a']++;
                target[c-'a'] = Math.max(target[c-'a'],temp[c-'a']);
            }
        }
            for(String a:A)
            {
                int afreq[] = new int[26];
                
                for(char c:a.toCharArray())
                {
                    afreq[c-'a']++;
                }
                if(subset(afreq,target)==true)
                {
                    res.add(a);
                }
            }
        
        return res;
    }
    public boolean subset(int word[],int target[])
    {
        for(int i=0;i<26;i++)
        {
            if(target[i]>word[i])
            {
                return false;
            }
        }
        return true;
    }
}