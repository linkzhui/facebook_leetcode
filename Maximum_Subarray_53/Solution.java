package Facebook.Maximum_Subarray_53;

//dp
//when current we are at index i position
//sum: represent the maximum sum of subarray, (index 0 to i);
//previous_sum: the maximum sum of continous subarray, when i-1 is the right boundary of the subarray
//then we want to calculate the maximum subarray end of i, there will be two choice:
//1. first, we accept the previous_sum, then solution will be previous_sum+nums[i]
//2 if we don't accept the previous_sum, then solution will be nums[i].

//the time complexity: O(n)
//space complexity: O(1)
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sol.maxSubArray(nums));

    }
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int previous_sum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            previous_sum = Math.max(nums[i],previous_sum+nums[i]);
            sum = Math.max(sum,previous_sum);
        }
        return sum;
    }
}
