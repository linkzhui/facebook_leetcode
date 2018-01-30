package Facebook.Letter_combination_of_a_phone_number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//backtracking
//for level 0, we expand current node to generate
//recursive down,
//when index == input.string length, return
//time complex:( how many character in that digits ^ digitis.length())
//space complex:O(n)
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String digits = "23";
        List<String> result = sol.letterCombinations(digits);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits == null || digits.length()==0)
        {
            return result;
        }
        String[] input = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(sb,input,digits,result,0);
        return result;
    }

    private void helper(StringBuilder sb, String[] input, String digits,List<String> result,int index)
    {
        if(index==digits.length())
        {
            result.add(sb.toString());
            return;
        }
        int num = digits.charAt(index)-'0'; //need to conver the character to intger
        for(int i = 0;i<input[num].length();i++)
        {
            sb.append(input[num].charAt(i));
            helper(sb,input,digits,result,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}