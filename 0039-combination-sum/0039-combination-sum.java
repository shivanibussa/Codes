class Solution 
{
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,target,res,temp,0);
        return res;
    }

    public void f(int nums[],int target,List<List<Integer>> res,List<Integer> temp,int ind)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(ind==nums.length)
            return;
        if(target>=nums[ind])
        {
            temp.add(nums[ind]);
            f(nums,target-nums[ind],res,temp,ind);
            temp.remove(temp.size()-1);
            f(nums,target,res,temp,ind+1);
        }
    }
}