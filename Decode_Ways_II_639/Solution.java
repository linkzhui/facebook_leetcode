package Facebook.Decode_Ways_II_639;

//DP:
//dp rule is f(i) = (f(i-1) * ways(i))+(f(i-2)*ways(i-1,i))
//Assumption: is the result smaller than largest Integer number?
public class Solution {
    public static int numDecodings(String s) {
        long[] res = new long[2];

        res[0] = ways(s.charAt(0)); //the first letter exist change is 0 or 9
        if(s.length() < 2)
            return (int)res[0];

        //the second letter exist change is first letter exist change time ways of second letter and the way of substring between 0 and 1
        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            //the reason why divide by 1000000007 is to avoid the integer stack overflow
            res[0] = temp;
        }
        return  (int)res[1];
    }

    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {

            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                //two possible, the first index could be 1 or 2,
                return 2;
            else
                //7<=second_value<=9
                //only possible value is between 17 and 19, the first index only can be 1
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                //1*
                //11 - 19
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                //2*
                //21-26
                return 6;
            }
        }
        return 0;
    }
}
