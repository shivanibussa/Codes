class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> al = new ArrayList<>();
        helper(res,nums,0,al);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int i, List<Integer> al)
    {
        if(i>=nums.length)
        {
            res.add(new ArrayList<>(al));
            return;
        }
        helper(res,nums,i+1,al);
        al.add(nums[i]);
        helper(res,nums,i+1,al);
        al.remove(al.size() - 1);
        
    }
}