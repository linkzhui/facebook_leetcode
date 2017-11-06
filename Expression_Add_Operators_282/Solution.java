package Facebook.Expression_Add_Operators_282;

import java.util.ArrayList;
import java.util.List;

//step1: we want to use dfs to solve this problem, the length of the tree is length is length of the string
//step2: for next level, we need to pass: 1. current index 2. target_value 3. input string 4. list<String> to store the result
//5. stringbuilder to store the path 6. current operation result 7. special value for next operator is multiplication
// (这个special value请看下面的little trick)
//the termination condition is:  when index of the string reach end the string
//time complex: we have three choice, "+,-,*", the tree's depth is n, each subtree, we have n different choice:
//therefore the time complex is :(n* 3^n) the last n is the depth of the tree

//Test:
//        - edge cases:
//// overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
//// 0 sequence: because we cannot have numbers with multiple digits started with zero, we have to deal with it too.
//        "105", 5 -> ["1*0+5","10-5"] //0 sequence
//        "00", 0 -> ["0+0", "0-0", "0*0"] //0 sequence
//        "3456237490", 9191 -> [] // no answer
//        "232", 8 -> ["2*3+2", "2+3*2"]


// !!!!! a little trick is that we should save the value that is to be multiplied in the next recursion.
//// for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
//// If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take it out from the existing eval.
//// You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4).
//
//        Time: O(n * 4^n) ???
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result,sb,num,target,0,0,0); //initial state
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, String nums, int target, int start, long eval, long mult) {

        if(start == nums.length())
        {
            if(eval == target)
            {
                result.add(sb.toString());
            }
            return;
        }
        for(int i = start;i<nums.length();i++)
        {
            long cur = Long.parseLong(nums.substring(start,i+1));
            int length = sb.length();
            if(nums.charAt(start) == '0' && i>start)
            {
                break;
            }
            if(start == 0)
            {
                dfs(result,sb.append(cur),nums,target,i+1,cur,cur);
                sb.setLength(length);
                continue;
            }

            dfs(result,sb.append('+').append(cur),nums,target,i+1,eval+cur,cur);
            sb.setLength(length);
            dfs(result,sb.append('-').append(cur),nums,target,i+1,eval-cur,-cur);
            sb.setLength(length);
            dfs(result,sb.append('*').append(cur),nums,target,i+1,eval-mult+mult*cur,mult*cur);
            sb.setLength(length);
        }
    }
}
