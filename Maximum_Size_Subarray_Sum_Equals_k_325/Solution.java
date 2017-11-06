package Facebook.Maximum_Size_Subarray_Sum_Equals_k_325;

import java.util.HashMap;

//using HashMap to store the sum_up values, because the subarray is continous array
//we store all the current sum up value into the hashmap, the key is current sum up value, the index is the current index
//if current sum up value is equal to target or current sum up value minus target is exist in hashmap, we find a subarray equal to target

//time complex:O(n)
//space complex:O(n) because we only store current sum up value
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        int element;
        for(int i = 0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum==k)
            {
                result = i+1; //the solution begin from index 0 to current index is result
            }
            else if(map.containsKey(sum-k))
            {
                result = Math.max(result,i-map.get(sum-k));
                //compare the current subarray is longer than previous solution or not
                //          0  1  2  3   4
                //  sum:    0  1  3  6  10
                //                      10-6 = 4-3 = 1
            }
            if(!map.containsKey(sum))
            {
                //make sure the key is exist or not, we only care about the first time exist key index, the longest one
                map.put(sum,i);
            }
        }
        return result;
    }
}