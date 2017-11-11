package Facebook.Regular_expression_matching_10;



public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s = "aab";
        String p = "a*b";
        System.out.println(sol.isMatch(s,p));
    }

// assumption: 1. * cannot be the first letter

//dp1: 这个比较好讲
    //dp[i][j]: means from 0 to i from string s and 0 to j from pattern p are matched or not
//    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//    3, If p.charAt(j) == '*':
//    here are two sub conditions:
//            1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//            2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
//                  dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
//                  or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//                  or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty


    public boolean isMatch_1(String s, String p)
    {
        if(s == null || p == null)
        {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1;i<p.length();i+=2)
        {
            //to avoid the case a*b* = {}
            //in this case, the * can only appear in the even number index, such as 1, 3, 5
            //therefore we only need to check if the even number in the pattern have continues *
            if(p.charAt(i)=='*' && dp[0][i-1]){
                //dp[i][j], are not same index in the string, the correspond index postion in the string is the i-1 and j-1
                dp[0][i+1] = true;
            }
        }
        for(int i = 0;i<s.length();i++)
        {
            for(int j = 0;j<p.length();j++)
            {
                if(p.charAt(j) == '.' || p.charAt(j)==s.charAt(i))
                {
                    //if two character match
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j)=='*')
                {
                    //if we find a *
                    if(p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.')
                    {
                        //* match zero element
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }
                    else{
                        //
                        dp[i+1][j+1] = (dp[i+1][j]||dp[i][j+1]||dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }




    //dp2: 不好讲，不要讲这个

//核心思路：----->从后往前看pattern的每一位，对于pattern的每一位，我们尽可能的把待匹配串string从后往前给匹配上。<------
// 我们用一个数组match[string.length() + 1]来表示string被匹配的情况，这里如果match[j]是true，而我们pattern正指向第i位，
// 则说明string从第j位到最后都已经被pattern第i位之前的某些部分给成功匹配了，所以我们不用再操心了。
// match[i]为true的条件是match[i + 1]为true，且string第i个字符也能被成功匹配。

//如果pattern的这一位是*，那我们要用这一位，来从后往前尝试匹配string，因为string后面是已经匹配好的，前面是还没匹配好的，
// 所以从前往后匹配星号可能会导致我们匹配了一些pattern该星号前面的星号应该匹配的部分。
// 而从后往前匹配则不会影响pattern该星号后面星号所匹配的部分，因为已经匹配的部分我们会直接跳过。
//the current character in the pattern is *, then we need to loop from end of the string to start, because we back of the string is matched with pattern,
//therefore is match(i+1) is true and. and loop from back to start, will not influence the match result after the *


// 如果pattern这一位不是*，那我们则不能匹配多个字符，我们只能匹配一个字符，这时候要对string从前往后匹配，
// 因为如果后面没被匹配，前面也肯定不会被匹配，所以从前向后能保证我们把pattern的这一位匹配到string当前 ---!最后面那个还没匹配的字符!-----。
// 这样如果那个字符能被匹配就通过了。
//if the character at this pattern is not a *, then we run loop from first character to end of the string, because we need to find the last unmatch character in the string
// to match this character in the pattern. current character at string is match the character right before the of * in the pattern, we find a match for from end to i.

//  aab
//  a*b

    //time complex: O(nm)  space complex:O(n)
    public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        match[s.length()] = true;
        for(int i = p.length() - 1; i >=0; i--){
            if(p.charAt(i) == '*'){
                // 如果是星号，从后往前匹配
                for(int j = s.length() - 1; j >= 0; j--){
                    match[j] = match[j] || (match[j + 1] && (p.charAt(i - 1) == '.' || (p.charAt(i - 1) == s.charAt(j))));
                }
                // 记得把i多减一，因为星号是和其前面的字符配合使用的
                i--;
            } else {
                // 如果不是星号，从前往后匹配
                for(int j = 0; j < s.length(); j++){
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(j)));
                }
                //无论刚才那pattern中最后一个character有没有匹配到string中任何一个字符，match[3]也要置为false。
                // 这样才能防止pattern最后字母没有匹配上，而pattern前面的部分反而把string的结尾给匹配了。
                // 还有如果pattern中是句号的话，那相当于字符相同。

                //to avoid the case such as "aab" "a*", to avoid the case like this when we run loop from back to front
                match[s.length()] = false;
            }
        }
        return match[0];
    }

}
