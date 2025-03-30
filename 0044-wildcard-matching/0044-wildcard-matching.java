import java.util.Arrays;

class Solution {
    public boolean solve(int index1, int index2, String text, String pattern, int[][] dp) {
        if (index1 < 0 && index2 < 0) return true;
        if (index2 < 0 && index1 >= 0) return false;
        if (index1 < 0 && index2 >= 0) {
            for (int i = 0; i <= index2; i++) {
                if (pattern.charAt(i) != '*') return false;
            }
            return true;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2] == 1;
        }

        if (text.charAt(index1) == pattern.charAt(index2) || pattern.charAt(index2) == '?') {
            dp[index1][index2] = solve(index1 - 1, index2 - 1, text, pattern, dp) ? 1 : 0;
        } else if (pattern.charAt(index2) == '*') {
            dp[index1][index2] = (solve(index1 - 1, index2, text, pattern, dp) || solve(index1, index2 - 1, text, pattern, dp)) ? 1 : 0;
        } else {
            dp[index1][index2] = 0;
        }
        return dp[index1][index2] == 1;
    }

    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       return  solve(n1-1,n2-1,s,p,dp);
    }
}