package Facebook.Subsets_78;

import java.util.ArrayList;
import java.util.List;

//思路： 每次遇到一个新元素，我们可以选择加或者不加，
//list<List<Integer>> will be used to store current possible combination, if we add a new element into the List,
//there will be have two possible situtation,
//1. we choose to add this value to all previous possible combination
//2. we choose not to add this value to all previous possible combination

//therefore, before we add current value into previous possible combination, we can make a copy of previous possible combination
//then add current value into the copy, and add copy to result. Then current result will have all possible combination which include or not include current element.

// current value is 4, and previous result is {(1,2},{1},{2},{}} -> copy of result -> add current value into copy of result -> copy: {{3},{1,2,3},{2,3}{1,3}}
//and we add copy back to result, then we will all combination with value from 1 to 3.


//time complexity: O(2^n)
//space complexity:O(2^n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++)
        {
            int size = result.size();
            for(int j = 0;j<size;j++)
            {
                List<Integer> copy = new ArrayList<>(result.get(j));
                copy.add(nums[i]);
                result.add(copy);
            }
        }
        return result;
    }
}
