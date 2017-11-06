package Facebook.Word_Break_139;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


//dp[j+1]: mean 0-j exist a word break or not
//we add all the element in the worddict into the hashset, to reduce the check list time
//we use for loop to check if we find s.substring(j,i) exist in the dictionary and dp[j] is true
//then dp[i] is true;
//after we go through the whole loop, we find if the last value in the dp array is true or not

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(String element:wordDict)
        {
            set.add(element);
        }
        for(int i = 0;i<s.length();i++)
        {
            for(int j = i;j>=0;j--)
            {
                if(dp[j] && set.contains(s.substring(j,i+1)))
                {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
