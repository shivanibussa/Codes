// Optimal Approach :

class Solution {
    public int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> mpp = new HashMap<>();
    int sum = 0;
    int count = 0;
    int n = nums.length;

    for(int i = 0; i<n; i++){
        sum+=nums[i];
        if(sum==k){
            count++;
        }
        int rem = sum - k;
        count+= mpp.getOrDefault(rem,0);
        mpp.put(sum,(mpp.getOrDefault(sum,0))+1);
    }
       return count;
    }
}


