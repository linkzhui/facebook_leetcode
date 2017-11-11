package Facebook.Word_Break_II_140;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//use recursion:
//we go throug the dictionary, if string is start with words from dict,
// then we remove the current word from the string, and keep recursion the rest of the substring,
//the recursion function will return all combination of the result,
//the termination condition is: the string length is 0, we know the recursion function reach end of the string, there
//must exist one solution.
//After we get the sub_result from the substring, we add current word into the sub_result to form a new_sub_result
//we return the new sub_result to the upper level.

//also, we after we finish process one substring, we will put current substring's all possible combination into the map,
//to avoid the duplicate string process for the future recursion.

//the time complexity: O(N^M) the n is how many words in dictionary, which mean at each level we have n different choices, (n 叉树)
// the M is the length of the string, the depth of the DFS function should less or equal than string length

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String,List<String>> map = new HashMap<>();
        return DFS(s,wordDict,map);
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res; //if it is end of the s, then input a empty string into the list, to mark it is end of the list<string>
        }
        for (String word : wordDict) {
            //go through the whole loop, if the s.startwith() match the word, then we keep doing the dfs for the rest of the string
            if (s.startsWith(word)) {
                //get all the partial result from the substring
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    //add current word into the substring's list
                    res.add(word + (sub.isEmpty()? "" : " ") + sub);
            }
        }
        map.put(s, res); //put the possible combination of substring into the map, to avoid the time to do duplicated string process
        return res;
    }

}
