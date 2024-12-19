class Solution 
{
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,ans,al,0);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> al, int ind)
    {
        // if(ind>=nums.length)
        // {
            ans.add(new ArrayList<>(al));
            // return;
        // }
        for(int i=ind;i<nums.length;i++)
        {
            if(ind<i && nums[i]==nums[i-1])
                continue;
            al.add(nums[i]);
            helper(nums,ans,al,i+1);
            al.remove(al.size()-1);
        }
    }
}