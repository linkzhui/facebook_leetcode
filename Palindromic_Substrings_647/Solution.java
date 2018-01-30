package Facebook.Palindromic_Substrings_647;

//time complexity O(n^2)
//space complexity O(n^2)
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];    //dp[i][j]: the substring between index i and index j are palindromic or not
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                //j - i <3，代表当前的string就是length <= 3.
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }
}
