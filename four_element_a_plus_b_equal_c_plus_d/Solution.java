package Facebook.four_element_a_plus_b_equal_c_plus_d;


import java.util.*;

//no duplicate element
//the number of all possible two sum is n^2. we can use two for loop, the first loop will run form (0 to array.length), the second nested for loop,
//the run from (i to array.length). the i is the index for first for loop.
//we store the two sum into hashmap, the key for hashmap will be the two sum result, the value for hashmap will be a list to store all the pairs have same sum result.
//we check if current two sum is exist in the hashmap or not. if the sum already exit in hashmap, we go through the list, add current pair to all other pairs in the list to make a expression, and add the expression to the result.
//if sum is not exist, we add current sum as the key into the hahsmap and add current pair as value for this key.
//O(n^2* m): n^2： we need n^2 time to through all possible two sum, m is the size of list pair for this sum, we need to make the expression with current pair to all other existed pairs
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sol.solution(nums).toArray()));
    }
    public List<String> solution(int[] nums)
    {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
        {
            return null;
        }
        Map<Integer,List<pair>> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++)
        {
            for(int j = i+1;j<nums.length;j++)
            {
                int sum = nums[i]+nums[j];
                List<pair> temp_list = map.get(sum);
                if(temp_list==null)
                {
                    //如果当前的sum没有出现在hashmap里面过
                    temp_list = new ArrayList<>();
                }
                else{
                    //当前的sum在hashmap里面出现过,我们就可以组成expression
                    for(pair element:temp_list)
                    {
                        //把之前的pair都iterator一遍, 然后把当前的pair和以前的pair组成expression加到result里面
                        //cause all the element is unique, therefore there will have no duplicate pair in the hashmap
                        String math_result = element.left+"+"+element.right+"="+nums[i]+"+"+nums[j];
                        result.add(math_result);
                    }
                }
                temp_list.add(new pair(nums[i],nums[j]));
                map.put(sum,temp_list);
            }
        }
        return result;
    }

    private class pair{
        int left;
        int right;
        public pair(int left, int right)
        {
            this.left =left;
            this.right =right;
        }
    }
}
