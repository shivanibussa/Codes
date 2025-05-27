class Solution 
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(candidates);
        f(res,al,candidates,target,0);
        return res;
    }
    public void f(List<List<Integer>> res, List<Integer> al,int candidates[],int target,int ind)
    {
        
        if(target==0)
        {
            res.add(new ArrayList<>(al));
            return;
        }
        for(int i=ind;i<candidates.length;i++)
        {
            if(i>ind && candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                break;
            al.add(candidates[i]);
            f(res,al,candidates,target-candidates[i],i+1);
            al.remove(al.size()-1);
        }
    }
}