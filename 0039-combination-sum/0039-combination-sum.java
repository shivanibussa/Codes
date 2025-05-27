class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
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

        if(ind==candidates.length || target<0)
            return;
        al.add(candidates[ind]);
        f(res,al,candidates,target-candidates[ind],ind);
        al.remove(al.size()-1);
        f(res,al,candidates,target,ind+1);
    }
}