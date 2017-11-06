package Facebook.Decode_ways_91;

//assumption: 01?
//can first character be 0?

//dp[i] = dp[i-1]+dp[i-2]
//there we need two variables to record previous two
//the prev will be finial solution.

//time O(n)
//space O(1) //cuz we only need two variable
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s = "0111";
        System.out.println(sol.numDecodings(s));
    }
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
        {
            return 0;
        }

        int prev_two = 1;
        int prev = 1;

        for(int i = 1; i<s.length();i++)
        {
            int temp = 0;
            if(s.charAt(i)!='0')
            {
                temp = prev;
            }
            int value = Integer.valueOf(s.substring(i-1,i+1));
            if(10<=value&& value<=26)
            {
                temp+=prev_two;
            }
            prev_two = prev;
            prev = temp;
        }
        return prev;
    }
}
