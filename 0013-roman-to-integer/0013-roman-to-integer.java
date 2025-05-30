class Solution 
{
    public int romanToInt(String s) 
    {
        HashMap<Character,Integer>hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int res = 0, n=s.length();
        res = hm.get(s.charAt(n-1));
        for(int i=n-2;i>=0;i--)
        {
            char curr = s.charAt(i);
            char prev = s.charAt(i+1);
            if(hm.get(curr)<hm.get(prev))
                res-=hm.get(curr);
            else
                res+=hm.get(curr);
        }
        return res;
    }
}