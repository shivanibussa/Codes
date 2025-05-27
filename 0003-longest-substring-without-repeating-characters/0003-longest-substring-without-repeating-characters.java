class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int l=0,res=0;
        HashSet<Character> hs = new HashSet<>();
        for(int r=0;r<s.length();r++)
        {
            Character curr = s.charAt(r);
            while(hs.contains(curr))
            {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(curr);
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}