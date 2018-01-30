package Facebook.Ascending_array_with_positive_negative_value_return_abs_value_array;

import java.util.Arrays;

//给一个有正有负的递增数列，返回⼀个按绝对值⼤⼩排列的数列
//use binary search to find the index that negative value and non-negative (include 0 and positive value) value are neighbor
//we mark index left for largest negative element in the array, we use right to mark smallest non-negative element in the array
//we use this two pointer to go through the array,
// if Math.abs(array[left])<array[right], we need to move left index to left by 1,
// if Math.abs(array[left])>=array[right], we need to move right index to right by 1.
//if left index or right index out of boundary,
//we check which index have not reach the end of the array, then we walk that unfinished pointer to fill the rest of element into new int array

//time complexity: (logm + m): log m used for binary search, then we go through the whole array again to build a new array with absolute value
//space complexity: O(m)   space to store the new int[], which is our result.
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {-3,-2,-1,1,2};
        System.out.println(Arrays.toString(sol.solution(array)));
    }
    public int[] solution(int[] array)
    {
        if(array == null || array.length == 0)
        {
            return array;
        }
        int left = 0;
        int right = array.length-1;
        while(left+1<right)
        {
            int mid = left+(right-left)/2;
            if(array[mid] >= 0)
            {
                right = mid;
            }
            else if(array[mid]<0)
            {
                left = mid;
            }
        }
        int[] result = new int[array.length];
        int i = 0;
        while(!(left==-1||right==array.length))
        {
            if(Math.abs(array[left])<array[right])
            {
                result[i++] = array[left--]*-1;
            }
            else{
                result[i++] = array[right++];
            }
        }
        while(right!=array.length)
        {
            result[i++] = array[right++];
        }
        while(left!=-1)
        {
            result[i++] = array[left--]*-1;
        }

        return result;
    }


}
