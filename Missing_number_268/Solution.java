package Facebook.Missing_number_268;
//solution 1: sort the array first, then go through the whole array to find the missing number
//time complexity: O(nlogn + n)
//space complexity: O(1) or if array cannot be modify, we need extra O(n) space to store the sorted array


//solution 2: bit Manipulation
// 3 XOR 3 = 0
// 0 XOR 3 = 3

//we go through the array first, XOR every element in the array,
//then use result to XOR element from 1 to array.length

//the result will be our missing number

// int[]: {1,2,3}  1 XOR 2 XOR 4 = result
//result XOR 1 XOR 2 XOR 3 XOR 4 = 3
//  (1 XOR 1) XOR (2 XOR 2) XOR (4 XOR 4) XOR 3
//  = 0 XOR 0 XOR 0 XOR 3 = 3

//the time complexity: O(n)
//space complexity: O(1)

import java.util.Arrays;

public class Solution {

    //----------------------------solution 1: sorting------------------------
    public int missingNumber_1(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }


    //solution 2: -----------------------------bit operation----------------------------------
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int missing = nums[0];
        for (int i = 1; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        missing ^= nums.length;
        return missing;
    }
}
