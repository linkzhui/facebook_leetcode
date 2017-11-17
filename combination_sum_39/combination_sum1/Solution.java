package Facebook.combination_sum_39.combination_sum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//        The same repeated number may be chosen from C unlimited number of times.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set [2, 3, 6, 7] and target 7,
//        A solution set is:
//[
//        [7],
//        [2, 2, 3]
//        ]

//each element from the array can be repeated use

public class Solution{
    public static void main(String[] args)
    {
        int[] candidates  = {10,1,2,7,6,5};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.combinationSum(candidates,8).toArray()));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(candidates.length==0)
        {
            return result;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        helper(candidates,target,0,list,result);
        return result;

    }

    void helper(int[] candidates, int target,int index, LinkedList<Integer> list,List<List<Integer>> result)
    {
        if(target<0)
        {
            return;
        }
        if(target==0)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<candidates.length;i++)
        {
            list.addFirst(candidates[i]);
            helper(candidates,target-candidates[i],i,list,result); //not i+1, because the same element from the array can be used again
            list.remove();
        }

    }

}
