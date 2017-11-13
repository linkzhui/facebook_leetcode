package Facebook.Subarray_sum_equals_K_560;


import java.util.HashMap;

//we need a variable to record the sum from index 0 to current index
//1. current sum - target is exist, we know there is a subarray equal to sum: sum - pre_sum = target
//2. if current sum is target, then we know we find one
//and we need a hashmap to store previous pre_sum, the value will be the frequency for pre_sum
//if we find sum - presum = target, and presum = 2, that mean there exist two continuous subarrays sum equal to target, we should add total count by 2.
public class Solution {
    public static void main(String[] args)
    {
        int[] nums = {-1,-1,1};
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(nums,0));
    }
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0|| nums == null)
        {
            return 0;
        }
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum == k)
            {
                //if current sum (0 to i) is target
                count++;
            }

            //we need to find pre_fix first, then add current sum -> 因为current_sum如果正好和current_sum - target的值一样的话，我们先把hashmap的value+1，
            //会导致算pre_sum出现的frequency不准确(pre_sum's frequency should not include current one if pre_sum is equal to current_sum)
            Integer value = map.get(sum-k);  // we check if there is exist one pre_sum = sum - target
            if(value !=null)
            {
                //if it is exist, we add count by frequency of this pre_sum.
                count+=value;
            }

            value = map.get(sum);
            if(value == null)
            {

                //if current sum is not exist in hashmap
                map.put(sum,1);
            }
            else{
                //add frequency by 1
                map.put(sum,value+1);
            }

        }

        return count;
    }
}
