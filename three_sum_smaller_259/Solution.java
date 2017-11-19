package Facebook.three_sum_smaller_259;

//nums[i] + nums[j] +nums[k] < target
//we could sort the array first, then use two pointer to find the result,
//if we go through the loop from 0 to array.length-1, (index i)
//then we set i+1 as left boundary and array.length-1 as right boundary
//then we doing left++ and right --  to narrow down our target result.

// we keep check if nums[i] + nums[left] + nums[right] < target
//then we know there is a possible result, nums[i] + nums[left] + (nums[left+1] -> nums[right] 这个中间的值都是答案)
//becuase all the number between nums[left+1] and nums[right] are less or equal than nums[right],
// therefore nums[i] + nums[left] + (nums[left+1] -> nums[right]) < target
// then we increase left boundary by 1: left ++

//if nums[i] + nums[left] + nums[right] > target, then we minus right boundary by 1: right --

//time complexity: O(nlogn+n^2), we sort the array first, then we go through the whole array take n time, then for each pointer, we run two pointer from i+1 to array.length, take n time.
//space complexity: O(1)

import java.util.Arrays;


public class Solution {
    public int threeSumSmaller(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right)
            {
                if(nums[left] + nums[right] + nums[i]<target)
                {
                    //固定两个点，nums【i】和 nums【left】，然后nums【left+1】到nums【right】都是possible result
                    result+=(right-left);
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}
