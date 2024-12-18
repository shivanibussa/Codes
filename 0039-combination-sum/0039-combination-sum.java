class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void findCombinations(int[] arr, int target, int ind, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            // Add the current combination to the result and stop recursion
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ind == arr.length || target < 0) {
            // Stop further recursion if index exceeds bounds or target is negative
            return;
        }

        // Include the current element
        if (target >= arr[ind]) {
            ds.add(arr[ind]);
            findCombinations(arr, target - arr[ind], ind, ds, ans);
            ds.remove(ds.size() - 1);
        }

        // Exclude the current element and move to the next
        findCombinations(arr, target, ind + 1, ds, ans);
    }
}
