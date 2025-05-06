class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Initialize the first row of dp with the first row of the matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the DP table row by row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Minimum of the three possible paths from the previous row
                int up = dp[i - 1][j];
                int leftDiagonal = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the minimum in the last row of dp
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }
}
