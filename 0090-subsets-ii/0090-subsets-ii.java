class Solution 
{
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(al,res,nums,0);
        return res;
    }
    public void f(List<Integer> al, List<List<Integer>> res, int nums[],int ind)
    {
        res.add(new ArrayList<>(al));
        for(int i=ind;i<nums.length;i++)
        {
            if(i>ind && nums[i]==nums[i-1])
                continue;

            al.add(nums[i]);
            f(al,res,nums,i+1);
            al.remove(al.size()-1);
        }

    }
}