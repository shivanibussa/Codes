class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        findcombinations(candidates,target,0,new ArrayList<>(), ans);
        return ans;
    }
    public void findcombinations(int []arr, int target, int ind, List<Integer>ds, List<List<Integer>> ans)
    {
        if(ind==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }
             return;
        }
        if(target>=arr[ind])
        {
            ds.add(arr[ind]);
            findcombinations(arr,target-arr[ind],ind,ds,ans);
            ds.remove(ds.size()-1);
        }
        findcombinations(arr,target,ind+1,ds,ans);
    }
}