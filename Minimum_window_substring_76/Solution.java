package Facebook.Minimum_window_substring_76;

//rule 1: the frequency of each character in T exist must equal or greater then those character's exist frequency in S
//rule 2: the first character of substring's exist frequency in S must have same exist frequency in T, for the same letter

import java.util.Arrays;

//time complex:O(n) all the element will be added into freqCur once and remove once
//space complex:O(t.length()+s.length());
public class Solution {
    public String minWindow(String s, String t) {
        //substring的开头的第一个元素，再substring里面出现的数量绝对会和T string里面这个character出现的次数相同
        int[] freqT = new int[256];
        int[] freqCur = new int[256];
        int count = 0; //how many character exist in T are find in S
        int start = 0; //the substring's left_boundary
        String result = "";
        for(int i = 0;i<t.length();i++)
        {
            freqT[t.charAt(i)]++;
        }
        for(int i = 0;i<s.length();i++)
        {
            char cur = s.charAt(i);
            if(freqT[cur]>0)
            {
                freqCur[cur]++;

                //这里的等于是上面一行，已经把当前的element 的 frequency ++了，所以要等于
                if(freqCur[cur]<=freqT[cur])
                {
                    count++;
                }

                //count == t.length(),means all the characters in the T are exist in S
                if(count==t.length())
                {

                    while(!(freqT[s.charAt(start)]>0 && freqT[s.charAt(start)]==freqCur[s.charAt(start)]))
                    {
                        //try to find the left_boundary of the substring
                        //because to the rule, the frequency of first character in substring must equal to frequency of this character exist in string T
                        //when this condition is meet, the while loop will break
                        //当前的character在T里面出现过，而且在这个character 在目前subwindow里面出现的次数正好等于character在T里面出现的次数
                        freqCur[s.charAt(start)]--;
                        start++;
                    }

                    //compare the current substring's length is less than previous result or not
                    if(result=="" || i-start+1<result.length())
                    {
                        result = s.substring(start,i+1);
                    }
                }
            }
        }
        return result;
    }
}



class Solution_1{
    public String minWindow(String s, String t) {
        char[] freq_t = new char[256];
        char[] freq_cur = new char[256];
        for(int i = 0;i<t.length();i++)
        {
            char a = t.charAt(i);
            freq_t[a]++;
        }

        int start = 0;
        int count = 0;
        String result = "";
        for(int i = 0;i<s.length();i++)
        {
            char cur = s.charAt(i);
            if(freq_t[cur]>0)
            {
                freq_cur[cur]++;
                if(freq_cur[cur]<=freq_t[cur])
                {
                    count++;
                }
                if(count==t.length())
                {

                    while(!(freq_t[s.charAt(start)]>0 && freq_t[s.charAt(start)]==freq_cur[s.charAt(start)]))
                    {
                        freq_cur[s.charAt(start++)]--;
                    }

                    if(result == ""||i-start+1<result.length())
                    {
                        result = s.substring(start,i+1);
                    }
                }
            }
        }
        return result;
    }
}