package Facebook.Contiguous_Array_525;


import java.util.HashMap;

//The idea is to change 0 in the original array to -1.
//then we calculate the sum from index 0 to index i,
//if we find sum[i, j] == 0 then we know there are even number of -1 and 1 between index i and j.
// Also put the sum value and its index into to a HashMap to make search faster.

//time complexity: O(n) n is the size for the array
//space complexity: O(n) since we need a hashmap to store the sum and its index, therefore we need O(n) extra dispace
public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max_length = 0;

        for(int i = 0;i<nums.length;i++)
        {
            sum+= nums[i]==1? 1:-1;
            if(sum == 0)
            {
                max_length = i+1;
            }

            if(sum!=0 && map.containsKey(sum))
            {
                max_length = Math.max(max_length,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }

        }
        return max_length;
    }
}
