class Solution 
{
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        String words[] = paragraph.replaceAll("[^0-9a-zA-Z]"," ").split("\\s+");
        List<String> bannedList = Arrays.asList(banned);
        HashMap<String,Integer> freqMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String res = "";
        for(String w:words)
        {
            w = w.toLowerCase();
            if(!bannedList.contains(w))
            {
                freqMap.put(w,freqMap.getOrDefault(w,0)+1);
                if(max<freqMap.get(w))
                {
                    max = freqMap.get(w);
                    res = w;
                }
            }
        }
        return res;
    }
}