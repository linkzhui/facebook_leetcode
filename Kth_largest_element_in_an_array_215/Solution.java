package Facebook.Kth_largest_element_in_an_array_215;


//Solution1: quick sort to sort the array, then find k th largest element in an array
//for average case of quick sort, we choose a pivot to divide array into half with nearly equal size,
//then we choose this pivot as our target, all element smaller than target will move to left side of target,
//every element bigger than target will move to right side of the target.

//the average time complexity: O(nlogn)  assume we can make a partition to divide the array into half with almost equal size

//the worst case for time complexity is O(n^n): if we choose a pivot that is most smallest element in the array, or the largest element in the array,
// then the depth of the our quick sort recursion method will be n level.

//therefore worst space complexity:  O(n) we have n level, each level require O(1) space
//average space complexity: O(logn)

//Solution 2: we can choose priority queue
//we maintain a size of k priority queue (ascending order), we need to push all the element into the priority queue for once.
//if current element is bigger than peek of the priority queue, we poll peek of the priority queue out of the priority queue, then
//push current element into the priority queue

//因为栈顶是当前最小的元素，所以priority queue里面有k个比栈顶大的元素，如果当前的元素比栈顶的元素要大的话，我们就把栈顶的元素给pop出来，
//这样就可以保证栈顶永远是kth_largest element in an array

//time complexity:O(nlogk) k is the size of the proority queue, n the number of total element
//space complexity: O(k) size for priority queue
import java.util.PriorityQueue;


public class Solution {

    //quick sort solution
    public int findKthLargest(int[] nums, int k){
        if(nums == null || nums.length == 0 || k==0)
        {
            return Integer.MIN_VALUE;
        }
        sort(nums);
        return nums[k-1];
    }
    public void sort(int[] array)
    {
        if(array==null || array.length==0)
        {
            return;
        }

        quicksort_2(array,0,array.length-1);
    }

    public void quicksort_2(int[] array, int left, int right){

        //corner case
        if(left>=right)
        {
            return;
        }

        int pivot = partion(array,left,right);

        quicksort_2(array,left,pivot-1);
        quicksort_2(array,pivot+1,right);

    }

    public int partion(int[] array, int left, int right)
    {
        //choose the left one as the pivot number of the array
        int target = array[left];

        int index = left; //index of smaller element
        for(int i = index+1;i<=right;i++)
        {
            if(array[i]<=target)
            {
                ++index;
                swap(array, index, i);
            }

        }
        //swap the current index element with most left element
        swap(array,left,index);
        return index;



    }
    public void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //priority queue solution
    public int findKthLargest_priority_queue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k)  pq.poll();
        }
        return pq.peek();
    }
}
