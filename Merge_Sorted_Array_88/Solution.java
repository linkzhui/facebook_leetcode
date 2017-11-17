package Facebook.Merge_Sorted_Array_88;

//从尾巴开始走，因为array1的空间足够大，可以存的下所有的值
//当一个array的index走到0了后，check一下
//如果array2还没有走完，就把array2剩下的element都一道array1的位置上
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_start = m - 1;
        int nums2_start = n - 1;
        int cur = m+n-1;
        while(nums1_start>=0 && nums2_start>=0)
        {
            nums1[cur--] = nums1[nums1_start] > nums2[nums2_start]? nums1[nums1_start--]:nums2[nums2_start--];
        }
        while(nums2_start>=0)
        {
            nums1[cur--] = nums2[nums2_start--];
        }
    }
}
