package Facebook.Product_of_Array_Except_Self_238;

//{1,2,3,4，5} -> 如果要求不包括3自己的乘积，那就是3左边的乘积 * 3右边的乘积 = (1*2) * (4*5);
//product of index i(exclusive current index element)：(product between index 0 and index i-1 ) * (product between index i+1 to end of the array)

//therefore we can calculate the left accumulate product first,
//we store the accumulate product from left to right store into a int array called result.
//result[i] = result[i-1]*nums[i-1];  because accumulate product is from 0 to its self's left side, therefore should not include its self.
//since first element's accumulate product is none, its it does not have left side, therefore, we initial result[0] to 1.

//after we finish calculate its left side's accumulate product, we need to calculate its right side's accumulate product, the idea is pretty same,
//and begin calculate the right side's accmulate product from end of the array to index 0, and we need to remember we cannot include our self's value in the accumulate product

//time complexity: O(n)  we need to go through the array twice, therefore it is
//space complexity: O(n)  extra n space to store the result.
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;  //initial condition
        for (int i = 1; i < n; i++) {
            //先计算从0到index i - 1的乘积
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1; //right是记录从右边到左边的product,因为最右边的数，不能乘以自己，所以我们right设置成1
        for (int i = n - 1; i >= 0; i--) {
            //right record the accumulate product from array_end to i-1,
            //自己是i，然后通过right记录，array end到i+1的product
            //把自己左手边的product和自己右手边product相乘就可以得出不包括自己的乘积了
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
