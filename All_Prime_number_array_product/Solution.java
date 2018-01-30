package Facebook.All_Prime_number_array_product;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {1,2,3,5,7,11};
        System.out.println(Arrays.toString(sol.solution(array).toArray()));
    }
    public List<Integer> solution(int[] array)
    {
        if(array == null || array.length == 0)
        {
            return null;
        }

        List<Integer> result = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        helper(result,array,0,1,0,set);
        return result;
    }

    private void helper(List<Integer> result, int[] array, int index, int product_result, int num_of_elem, HashSet<Integer> set)
    {
        if(index == array.length)
        {
            return;
        }


        //确保至少有2个element才可以相乘，把乘积加到result里面
        if(num_of_elem>=1 && set.add(product_result*array[index]))
        {
            result.add(product_result*array[index]);
        }
        helper(result,array,index+1,product_result*array[index],num_of_elem+1,set);
        helper(result,array,index+1,product_result,num_of_elem,set);
    }
}
