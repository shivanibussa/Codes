class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> freq[] = new List[nums.length+1];
        int res[] = new int[k];
        int c=0;
        for(int i=0;i<freq.length;i++)
        {
            freq[i] = new ArrayList<>();
        }
        for(int n:nums)
            hm.put(n,(hm.getOrDefault(n,0)+1));
        for(Map.Entry<Integer,Integer> entry:hm.entrySet())
        {
            freq[entry.getValue()].add(entry.getKey());
        }
        for(int i=freq.length-1;i>=0;i--)
        {
            for(int f:freq[i])
            {
                if(c==k)
                    break;
                res[c++] = f;
            }
        }
        
        return res;

    }
}