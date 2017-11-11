package Facebook.Rotate_array_189;


//question: if k is larger than nums.length? can we use k % nums.length
//solution 1: yahoo yahoo
// time O(n)
// space O(1)

//solution 2: The simplest approach is to rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step
//time O(n*k)
//space O(1)

//solution 3: using extra array
//time: O(n)
//space: O(1)
public class Solution {

    public void solution_1(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<0)
        {
            return;
        }

        k %= nums.length; //   1. if k > nums.length

        reverse(nums, 0, nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private void reverse(int[] nums, int start, int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public void solution_2(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void solution_3 (int[] nums, int k) {
        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
