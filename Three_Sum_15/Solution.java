package Facebook.Three_Sum_15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//assumption: is there have duplicate value?
//assumption: is this array sorted?


//method 1: bad
// do 2 sum first, then do two sum again
// first put all the element into the hashmap
//then run the whole loop again to get the two sum
//store the two sum result into hashmap again
//hashset to record all the two sum pair
//then run the hashmap again to get the three sum result.
//time complex: O (3n)
//space complex: O (n^2 -> record two sum result + n^2-> record hashset + n hashset)


//use two pointer
//sort the array first (if array is unsorted)
//then go through the whole array, because the array is sort,
// therefore if we choose the value of current index in the array as lowest number in the potential list
//then we do two sum search between current index +1 to end of the array,
//the possible result is only exist between current index +1 to end of the array
//inorder to avoid the duplicate case(if have duplicate element in the array)
//we always check the nearby values
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] num = {-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(sol.threeSum(num).toArray()));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }

            int low = i+1;
            int high = nums.length-1;
            while(low<high)
            {
                if(nums[low]+nums[high]+nums[i]==0)
                {
                    Integer[] number = {nums[i],nums[low],nums[high]};
                    List<Integer> child_list = new LinkedList<>(Arrays.asList(number));
                    while(low<high && nums[low] == nums[low+1])
                    {
                        low++;
                    }
                    while(low<high && nums[high] == nums[high-1])
                    {
                        high--;
                    }
                    result.add(child_list);
                }
                else if(nums[low]+nums[high]+nums[i]>0)
                {
                    high--;
                }
                else{
                    low++;
                }
            }

        }
        return result;
    }
}
