package Facebook.Implement_strstr_28;

//keep a size of k subwindow, and move the size subwindow from 0 to s.length()-k.length().
//time complex: O(n*m)
//space complex: O(1)
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
        {
            return -1;
        }
        if(needle.length() == 0)
        {
            return 0;
        }
        for(int i = 0;i<=haystack.length() - needle.length();i++)
        {
            //这里需要<=，因为有可能haystack.length() == needle.length()
            for(int j = 0;j<=needle.length();j++)
            {
                if(j==needle.length())
                {
                    return i;
                }
                if(haystack.charAt(i+j)!=needle.charAt(j))
                {
                    break;
                }

            }
        }
        return -1;
    }
}
