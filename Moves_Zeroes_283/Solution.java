package Facebook.Moves_Zeroes_283;

//Two pointer,
// time complexity: O(n)
//we need to pointer, the current pointer means the current index, the start pointer means //the result from 0 to start (not include from start) are all zero,
//when we see a unzero element, we move the element to start pointer, then the cur pointer and start pointer both move 1
//if it is a unzero element, we only move the current pointer
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return;
        }
        int start = 0;

        //the result from 0 to start (not include from start) are all zero
        int cur = 0;
        while(cur<nums.length)
        {
            if(nums[cur]!=0)
            {
                nums[start++] = nums[cur];
            }
            cur++;
        }
        while(start<nums.length)
        {
            nums[start++] = 0;
        }
    }
}
