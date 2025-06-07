class Solution 
{
    public int lengthOfLIS(int[] arr) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            int idx = Collections.binarySearch(res,arr[i]);
            if(idx<0)
            {
                idx = -(idx+1);
            }
            if(res.size()>idx)
            {
                res.set(idx,arr[i]);
            }
            else{
            res.add(arr[i]);
            }
        }
        return res.size();
    }
}