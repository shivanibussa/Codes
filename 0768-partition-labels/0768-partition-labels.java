class Solution 
{
    public List<Integer> partitionLabels(String s) 
    {
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),i);
        }
        List<Integer> res = new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            end = Math.max(end,hm.get(ch));
            if(end==i)
            {
                res.add(end-start+1);
                start=i+1;
            }
        }
    return res;
    }
}