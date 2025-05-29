class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);       // Odd length palindrome
            String even = expandAroundCenter(s, i, i + 1);  // Even length palindrome

            // Update max if a longer palindrome is found
            if (odd.length() > max.length()) {
                max = odd;
            }
            if (even.length() > max.length()) {
                max = even;
            }
        }
        return max;
    }

    // Helper method to expand around the center and return the palindrome
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Substring from left+1 to right (exclusive)
        return s.substring(left + 1, right);
    }
}
