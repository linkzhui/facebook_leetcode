package Facebook.Intersection_of_two_arrays_349;

//Solution 1: use hashset, we put the int array with smaller length into the hashmap, the key will the element in the int[],
//the value will be the 0 (zero means we didn't find any match for those two arrays yet),
// then we go through the int array 2, if the we find element in array2 exist in the hashmap and the element have not been added
//into the final result yet, we add this element into the final result, and update the this hashmap's value of this element to 1 (1 means we already add this element into the result).

//the time complex is: O(n + m)
//space complex: O(Math.min(n+m));


//Solution 2: use binary search, go though the shorter one, do binary search in the longer one, but we need to sort the array first
//time complex: O(nlogm + nlogn + mlogm) : the n is smaller length of array, m is longer length of array
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] intersection_solution_2(int[] nums1,int[] nums2)
    {
        if(nums1 == null || nums2  == null || nums1.length==0 || nums2.length == 0)
        {
            return new int[0];
        }
        List<Integer> result = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length < nums2.length)
        {
            helper(nums1,nums2,result);
        }
        else{
            helper(nums2,nums1,result);
        }
        int[] final_result = new int[result.size()];
        for(int i = 0;i<result.size();i++)
        {
            final_result[i] = result.get(i);
        }
        return final_result;
    }

    private void helper(int[] nums1, int[] nums2, List<Integer> result)
    {
        for(int i = 0;i<nums1.length;i++)
        {
            if(i==0 ||(i!=0 && nums1[i-1] != nums1[i]))
            {
                int start = 0;
                int end = nums2.length-1;
                while(start<=end)
                {
                    int mid = start+(end-start)/2;
                    if(nums2[mid] == nums1[i])
                    {
                        result.add(nums1[i]);
                        break;
                    }
                    else if(nums2[mid]<nums1[i])
                    {

                        start = mid+1;
                    }
                    else {
                        end = mid-1;
                    }
                }
            }

        }
    }
    public int[] intersection_solution_1(int[] nums1,int[] nums2) {
        if(nums1 == null || nums2  == null || nums1.length==0 || nums2.length == 0)
        {
            return new int[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        if(nums1.length > nums2.length)
        {
            helper(nums2,nums1,result,map);
        }
        else{
            helper(nums1,nums2,result,map);
        }
        int[] final_result = new int[result.size()];
        for(int i = 0;i<result.size();i++)
        {
            final_result[i] = result.get(i);
        }
        return final_result;
    }

    private void helper(int[] nums1,int[] nums2, List<Integer> result, HashMap<Integer,Integer> map)
    {
        for(Integer element:nums1)
        {
            map.put(element,0);
        }
        for(Integer element:nums2)
        {
            Integer temp = map.get(element);
            if(temp!=null && temp == 0)
            {
                result.add(element);
                map.put(element,1);
            }
        }
    }
}
