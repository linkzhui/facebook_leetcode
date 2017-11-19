package Facebook.Intersection_of_two_arrays_II_350;


//Question 1: is array sorted?
//Question 2: is array1 and array2 have similar size?

//Solution 1: if array is unsorted -> use hashmap
//put all element from one array with smaller array size into hashmap, the key will be element, the value if be this element's frequency
//go through another array, check intersection element.



//Solution 2: if array is sorted, we use two pointers, each pointer point at beginning index of the two array,
// if array1[index_1] == array2[index_2], both index add by 1, and add current element into the result
// if array1[index_1] < array2[index_2], index_1++
// if array1[index_1] > array2[index_2], index_2++


//Follow up:
//What if the given array is already sorted? How would you optimize your algorithm?
    //solution 1: binary search all element from smaller in larger size array. O(nlogm) 如果m的size很大的话，binary search的办法比较好
    //solution 2: use two pointer O(n+m) ， 如果两个array的size相差不大的话，这个办法比较好

//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//solution 1: (if array is sorted), we can use binary search, we use for loop to go through the array with smaller size, search current element in the other array.
//since the element maybe duplicated, therefore we need to find the first occurrence of this element in larger size array.
//time complexity:O(mlogn) m is smaller size array, n is larger size array
//space complexity: O(1)

//Soltion 2: (array is unsorted)also we can store the array with smaller size into the hashmap, then go through the array with longer size
//time complexity O(m+n)
//space complexity O(n) : n is the size of smaller array.


//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//      Assumption 1:  可以把size比较小的array放到memory吗？ 如果可以把size 比较小的array里面的element，都放到hashmap里，然后把size比较大的array分为多个chuncks，分别比较    If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
//     Assumption 2： 如果都不可以，把两个array都sort了先，然后每次读两个array的一部分，然后进行比较   If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {


    //-----------------------------Solution 1: HashMap----------------------

    //假设array 1的size比较小，array 2的size 比较大
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num:nums1)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int i = 0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]))
            {
                map.put(nums2[i],map.get(nums2[i])-1);
                result.add(nums2[i]);
                if(map.get(nums2[i])==0)
                {
                    map.remove(nums2[i]);
                }
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for(int num:result)
        {
            res[i++] = num;
        }
        return res;
    }

    //Solution 2: Array is sorted, use two pointer
    public int[] intersect_1(int[] nums1, int[] nums2) {

        //**********array如果已经是sorted的话，就不需要这一步了
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //***********

        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1=0, p2=0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<nums2[p2]){
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                p2++;
            }else{
                list.add(nums1[p1]);
                p1++;
                p2++;

            }
        }

        //把list转成int array，因为是int，primitive type,所以不能直接用List.toArray().
        int[] result = new int[list.size()];
        int i=0;
        while(i<list.size()){
            result[i]=list.get(i);
            i++;
        }
        return result;
    }

}
