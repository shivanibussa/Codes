class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper(nums,ans,al,freq);
        return ans;
    }
    public static void helper(int[] nums,List<List<Integer>> ans, List<Integer>al, boolean[] freq)
    {
        if(al.size()==nums.length)
        {
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!freq[i])
            {
                freq[i] = true;
                al.add(nums[i]);
                helper(nums,ans,al,freq);
                al.remove(al.size()-1);
                freq[i] = false;
            }
        }
    }
}