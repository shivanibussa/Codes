class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int idx = Collections.binarySearch(al,nums[i]);
            if(idx<0)
            {
                idx = -(idx+1);
            }
            if(al.size()>idx)
                al.set(idx,nums[i]);
            else
                al.add(nums[i]);
        }
        return al.size();
    }
}