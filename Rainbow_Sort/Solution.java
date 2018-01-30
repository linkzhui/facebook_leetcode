package Facebook.Rainbow_Sort;

//rainbow sort: use three pointers, one pointer is current index in the array,
// one pointer is name left, all element begin from 0 to left(exclude left) are marked Low, from left to right are all marked Medium,
// from right (exclude the right) to end of array are marked high.

//we go throught the array, from index 0 to end,
// condition 1: if current element in the array is equal to 0
//              nums[cur_index] = nums[start];
//

public class Solution {
    public void sortColors(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return;
        }
        int left = 0;
        int right = nums.length-1;
        int cur_index = 0;

        int low = 3;
        int medium = 5;
        while(cur_index<=right)
        {
            //we mark current element as temp
            int temp = nums[cur_index];

            if(nums[cur_index]<low)
            {
                //because current element belong to low, and index 0 to left-1 are belong to low,
                // therefore we need to swap the element at current index with left index
                //then move start pointer and current pointer both to left by 1.
                nums[cur_index++] = nums[left];
                nums[left++]=temp;
            }
            else if(low<=nums[cur_index] && nums[cur_index]<=medium)
            {

                cur_index++;
            }
            else{
                //swap element from current index and right index,
                //since we don't know the previous element in the right index belong to which range, and that element have been swaped into current index
                //therefore we only move right index to left by 1, and while loop will check current index's element again
                nums[cur_index] = nums[right];
                nums[right--] = temp;
            }
        }
    }
}
