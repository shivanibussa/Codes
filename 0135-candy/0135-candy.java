class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int right = 1;
        int candy = 0;

        // Fill the left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Start with the last child's candy
        candy += left[n - 1];

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            int cur;
            if (ratings[i] > ratings[i + 1]) {
                cur = right + 1;
            } else {
                cur = 1;
            }
            right = cur; // Update right
            candy += Math.max(left[i], cur);
        }

        return candy;
    }
}
