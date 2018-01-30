package Facebook.Moves_Zeroes_283;

//Two pointer,
// time complexity: O(n)
//we need to pointer, we name one point current and one point start
// cur: the current index,
// start: all the element from 0 to start (exclude from start) are nonzeros,

//then we go through the array from index 0, if current element is nonzeros, we replace start index value with current element (nums[start++] = nums[cur++])
//if current element is zeros, we keep move current pointer.
//after
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
                nums[start++] = nums[cur++];
            }
        }

        while(start<nums.length)
        {
            nums[start++] = 0;
        }
    }
}
