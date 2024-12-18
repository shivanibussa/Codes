class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void findCombinations(int[] arr, int target, int ind, List<Integer> ds, List<List<Integer>> ans) 
    {
        
        if (target == 0) 
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++)
        {
            if(i>ind && arr[i]==arr[i-1])
            {
                continue;
            }
            if(arr[i]>target)
            {
                break;
            }
            ds.add(arr[i]);
            findCombinations(arr, target - arr[i], i + 1, ds, ans); // Move to the next index
            ds.remove(ds.size() - 1);
        }
            
    }
}
