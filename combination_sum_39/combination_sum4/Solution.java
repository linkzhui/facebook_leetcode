package Facebook.combination_sum_39.combination_sum4;

//Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
//Example:
//
//nums = [1, 2, 3]
//target = 4
//
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//
//Note that different sequences are counted as different combinations.
//
//Therefore the output is 7.





//So we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target,
// this number can be any one in the array, right? So the # of combinations of target,
// comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].
//In the example given, we can actually find the # of combinations of 4 with the # of combinations of
// 3(4 - 1), 2(4- 2) and 1(4 - 3). As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {4,2,1};
        System.out.println(sol.combinationSum4_1(nums,32));
    }

    public int combinationSum4_1(int[] nums, int target){
        if(nums.length==0 || nums == null || target <=0)
        {
            return 0;
        }
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return helper(nums,dp,target);
    }

    private int helper(int[] nums, int[] dp, int target)
    {
        if(dp[target] != -1)
        {
            return dp[target];
        }
        int res = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(target>=nums[i])
            {
                res += helper(nums,dp,target-nums[i]);
            }

        }
        dp[target] = res;
        return res;
    }
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        if(nums==null || nums.length == 0 || target <0)
        {
            return result;
        }
        helper(nums, target,0,new LinkedList<>(),result);
        return result;
    }

    private void helper(int[] nums, int target, int index, LinkedList<Integer> list, List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0)
        {
            return;
        }
        if(nums[index]>0)
        {
            for(int i = index;i<nums.length;i++)
            {
                list.addFirst(nums[i]);
                helper(nums,target-nums[i],index,list,result);
                list.remove();
            }
        }
    }
}
