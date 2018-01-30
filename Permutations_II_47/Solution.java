package Facebook.Permutations_II_47;

import java.lang.reflect.Array;
import java.util.*;

//swap swap
//use dfs to keep recursion, we need to pass: current index, a arraylist about input,
//hashset to avoid the dupplicate solution, List<list> to store final result
//the termination condition for dfs, the current index == input.length
//the recursion rule: the current path is not exist in the hashset yet
//swap the current index with
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        Set<List<Integer>> set = new HashSet<>();
        Integer[] new_nums = new Integer[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
            new_nums[i] = nums[i];
        }
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(new_nums));
        helper(0,set,input,result);
        return result;
    }

    //132
    private void helper(int cur, Set<List<Integer>> set, ArrayList<Integer> nums, List<List<Integer>> result)
    {
        //index (var cur) is the current level er are trying.
        if(cur == nums.size())
        {
            ArrayList<Integer> part_result = new ArrayList<>(nums);
            result.add(part_result);
        }


        //put each letter in the index-th position of the input str
        for(int i = cur;i<nums.size();i++)
        {
            swap(nums,cur,i);
            if(set.add(new ArrayList<>(nums.subList(0,i+1)))){
                helper(i+1,set,nums,result);
            }
            swap(nums,cur,i);
        }
    }

    private void swap(ArrayList<Integer> nums,int left, int right)
    {
        Integer temp = nums.get(left);
        nums.set(left,nums.get(right));
        nums.set(right,temp);
    }
}
