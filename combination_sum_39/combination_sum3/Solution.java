package Facebook.combination_sum_39.combination_sum3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n,
// given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<List<Integer>> result;
        result = sol.combinationSum3(3,15);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if(k<=0||n<=0||k>n)
        {
            return result;
        }
        int[] array = {1,2,3,4,5,6,7,8,9};
        helper(array,1,k,n,list,result);
        return result;
    }

    private void helper(int[] array,int index,int k, int target, LinkedList<Integer> list, List<List<Integer>> result)
    {
        if(target == 0 && k==0)
        {
            result.add(new LinkedList<>(list));
            return;
        }
        if(index==10||target<0||k<0)
        {
            return;
        }

        for(int i = index;i<=9;i++)
        {
            list.addFirst(i);
            helper(array,i+1,k-1,target-i,list,result);
            list.remove();
        }
    }
}
