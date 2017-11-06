package Facebook.Remove_Invalid_Parentheses_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//better solution:
//key to make sure the a string is valid parenthesis, the left parentheses will equal to right parentheses.
//we use counter, when we meet a left parentheses, we increase the counter by 1, then we decrease the counter by 1
//if we find a unpaired right parenthesis, begin from last remove element index to find a possible solution to remove the right parenthesis
//then we keep recursion the rest of string.

//after the that, we reverser the string, to remove the unpaired left parenthesis, using the same method
class Solution1{

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        int counter = 0;
        for (int i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0])
            {
                counter++;
            }
            if (s.charAt(i) == par[1])
            {
                counter--;
            }
            if (counter<0){
                //we find a unpaired right parenthesis, therefore we need to find a place to remove it, the removed index should between last removed index and current index,

                for (int j = last_j; j <= i; ++j)
                {
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    {
                        //s.charAt(j - 1) != par[1] is avoid the duplicated result, if there is consecutive right parenthesis, we only delete the first right parenthesis.
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                    }
                }

                //if we already find a unpaired right parenthesis, then we only need to recursion the rest of the string
                return;
            }

        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}


//worse solution:

//scan the whole array to find how many r parentheses we need to remove and how many right parentheses we need remove
//1.Set max removal boundaries: rmL, rmR, if not set, will return all possibilities
//then run dfs, when we meet a right or left parenthses, we check if the rml or rmr is bigger than 0, if it is bigger than 0,
//we can choose to remove it or keep it, if it is 0, we only can choose to keep it.
//2. Check if open parentheses == 0 to add result in HashSet(avoid duplicates)
//3. scan the string for dfs (no for loop since we don't need ordering)
//4. in dfs, we choose either use or remove　"(" or ")", add open when use "(", remove when use ")"

//for dfs funvtion, we need pass the original String, current index in the string, hashset to avoid duplicated solution, StringBuilder fot the path,
//remove right parentheses, remove left parentheses and current unpaired parentheses
//the "open" means current unpaired parentheses
//time complexity: O(2^n)
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                rmL++;
            }else if(s.charAt(i)==')'){
                if(rmL>0){
                    rmL--;
                }else{
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<String>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        int len = sb.length();//decision point
        if(open<0||rmL<0||rmR<0) return;//rmL rmR limit the max removal boundary,
        //else will return all possibilities["","()()","()","(())","()()()","(())()"]
        if(i==s.length()){
            if(open==0)res.add(sb.toString());//back tracking till the full length
            return;
        }else{
            //we don't need for loop since no ordering(not like subsets,permu problem)
            char c = s.charAt(i);
            if(c=='('){//order matters here, once append c to sb, sb contains c when backtracking
                dfs(s,i+1,res,sb,rmL-1,rmR,open); //remove '('
                dfs(s,i+1,res,sb.append('('),rmL,rmR,open+1); //use '('
            }else if(c==')'){
                dfs(s,i+1,res,sb,rmL,rmR-1,open); //remove ')'
                dfs(s,i+1,res,sb.append(')'),rmL,rmR,open-1); //use ')'
            }else{
                dfs(s,i+1,res,sb.append(c),rmL,rmR,open);// append non '(',')' char
            }
        }
        sb.setLength(len);//reset back to decision point -- remove last char of sb
    }
}
