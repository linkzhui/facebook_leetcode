package Facebook.Search_in_rotated_sorted_array_33;


//use binary to search the target
//case 1: if nums[start]<nums[mid]<nums[end]; no rotation
//case 2: if nums[start]< nums[mid] && nums[mid] > nums[end]; the first half of the array is rotated
//case 3: if nums[start]> nums[mid] && nums[mid] < nums[end]; the second half of the array is rotated

//then we can check if nums[start]< nums[mid], we know the first half part is ascending order,
//if target>=nums[start] && target < nums[mid], we know the target must in the range between start and mid

//if we know second half part is in ascending order, then we target>nums[mid] && targer < nums[end], target must in the range between
//mid and end




public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end)
        {
            mid = start+(end-start)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[start]<nums[mid])
            {
                //the first half part is in ascending order
                if(target>=nums[start] && target < nums[mid])
                {
                    //
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[end])
                {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1; //if we didn't find the target, return -1;
    }
}
