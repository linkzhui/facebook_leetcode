package Facebook.Longest_Common_Prefix_14;

//解法：把array里的第一个string当做是prefix，
//然后比较这个prefix是不是也是接下来string的prefix, 通过for loop来比较每个character是不是相等 （这里，我们把string转换成char array，可以节省access time）
//当我们发现当前的prefix跟这个string，不匹配的时候，我们更新prefix
//time complexity: O(m*n)  n是number of strings，m是maximum length of string
//space complexity: O(m)  因为我们要把string 转换成char array，所以需要额外的m的空间，如果我们不用这个额外的m的空间的话，我们可以用iterator来做。
//space complexity 就会变成O（1）

//String a = "abcde";
//String b = "abdc";
//System.out.println(b.startsWith(a));  如果比较的长度不一样，也没有关系

import java.util.Arrays;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
        {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++)
        {
            int j = 0;

            //这里把两个string 转换成char array，可以节省string的access time.
            char[] cur_array = strs[i].toCharArray();
            char[] prefix_1 = prefix.toCharArray();

            for(;j<Math.min(prefix_1.length,strs[i].length());j++)
            {
                //从头开始比较两个string的prefix是不是相等
                if(prefix_1[j]!=cur_array[j])
                {
                    //如果不相等，break
                    break;
                }
            }
            if(j!=prefix.length())
            {
                //1. 当前string和prefix有共同的prefix，但是当前的string比较短，所有就要把prefix更新为短的string
                //2. 当前的string 和 以前的prefix的共同prefix，在j的位置停下来了，j比两个string的length都要短
                prefix = prefix.substring(0,j);
            }
        }
        return prefix;
    }
}
