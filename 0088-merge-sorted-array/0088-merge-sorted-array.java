class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of the arrays
        int i = m - 1; // Pointer for the last element in nums1's valid part
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the last position in nums1's full length

        // Merge the arrays from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // No need to handle remaining elements in nums1 as they are already in place
    }
}
