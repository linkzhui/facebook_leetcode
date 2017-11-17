package Facebook.Longest_Substring_Without_Repeating_Characters_3;

//we need a hashset to record if current charaster is exist in the substring or not
//if it is not include in the substring, we add current substring length by 1, and compare the current substring length and max_length
//if this character already exist, then we use i - cur_length + 1 to find the start index of current index, to delete character from hashamp begin from start index
//if we find the repeated character, then we stop delete

//space complexity: O(n)  only a int[] with 256 length
//time complexity: O(2n) -> O(n)  所有的元素都会进hashmap一次然后出hashmap一次
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int[] map = new int[256];
        int max_length = 0;
        int cur_length = 0;
        int i =0;
        for(;i<s.length();i++)
        {
            cur_length++;   //提前加1加回来
            if(map[s.charAt(i)]==0)
            {
                map[s.charAt(i)]++;
            }
            else{
                int j = i - cur_length+1;
                //current substring's start index
                //这里为什么要加1，因为我们提前把cur_length+1了，所有减完后要加1加回来

                while(j<i && s.charAt(j)!=s.charAt(i))
                {
                    //如果当前index比i要小，同时不是重复元素，
                    //cur length --, 同时从hashmap里面删掉这个元素
                    map[s.charAt(j++)]--;
                    cur_length--;
                }
                cur_length--;
            }
            //比较当前的长度和max 长度，哪个比较长
            max_length=Math.max(cur_length,max_length);
        }
        return max_length;
    }
}
