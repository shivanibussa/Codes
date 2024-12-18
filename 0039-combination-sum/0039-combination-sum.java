class Solution 
{
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(nums,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public static void findCombinations(int[] nums, int ind, int target,List<Integer>ds, List<List<Integer>>ans)
    {
        if(ind==nums.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(target>=nums[ind])
        {
            ds.add(nums[ind]);
            findCombinations(nums,ind,target-nums[ind],ds,ans);
            ds.remove(ds.size()-1);
        }
        findCombinations(nums,ind+1,target,ds,ans);
        
    }
}