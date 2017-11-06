package Facebook.Search_in_rotated_sorted_array_II;

//if nums[start] == nums[mid], start++,
//else  nums[end] == nums[mid],end --;

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length == 0)
        {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                return true;
            }
            else if(nums[mid] > nums[start]){
                if(target < nums[mid] && nums[start]<=target)
                {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(nums[mid] < nums[end]){
                //nums[mid]<nums[start]
                if(nums[mid]<target && target <= nums[end])
                {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else if(nums[mid] == nums[start]){
                start++;
            }
            else
            {
                //nums[mid] == nums[end]
                end--;
            }
        }
        return false;
    }
}
