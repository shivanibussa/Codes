class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        f(nums,res,0);
        return res;
    }
    public void f(int nums[],List<List<Integer>> res,int ind)
    {
        if(ind==nums.length)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int n:nums)
                temp.add(n);
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<nums.length;i++)
        {
            swap(nums,i,ind);
            f(nums,res,ind+1);
            swap(nums,i,ind);
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}