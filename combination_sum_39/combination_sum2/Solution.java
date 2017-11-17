package Facebook.combination_sum_39.combination_sum2;

//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//A solution set is:
//[
//[1, 7],
//[1, 2, 5],
//[2, 6],
//[1, 1, 6]
//]


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<List<Integer>> result;
        int[] candidates = {10,1,2,7,6,1,5};
        result = sol.combinationSum2(candidates,8);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates.length == 0) {
            return result;
        }
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,list,result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, LinkedList<Integer> list, List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new LinkedList<>(list));
            return;
        }
        else if(index==candidates.length||target<0)
        {
            return;
        }
        if(candidates[index]>0) {
            for (int i = index;i<candidates.length;i++)
            {
                if((i>index && candidates[i]==candidates[i-1])||candidates[i]<0) //i>index && candidates[i]==candidates[i-1] avoid the duplicate case
                {
                    continue;
                }
                else{
                    list.addFirst(candidates[i]);
                    helper(candidates,target-candidates[i],i+1,list,result);
                    list.remove();
                }
            }
        }
    }
}
