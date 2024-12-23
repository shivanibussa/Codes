class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    public static void helper(int[] nums,int ind, List<List<Integer>> ans )
    {
        if(ind==nums.length)
        {
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            helper(nums,ind+1,ans);
            swap(i,ind,nums);
        }
    }
    private static void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}