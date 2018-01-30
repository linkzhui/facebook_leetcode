package Facebook.one_swap_ascending_order_array;

//记录2个指针值，left，right ，3 个boolean，判断有没有有swap过，左指针有没有找到，右指针有没有找到
//一个从left开始扫描，一个从end of array开始扫描，
//left确保是不是都是递增的，如果不是就停下来
//right确保是不是都是递减的，如果不是就停下来
//然后把left和right的值换一下
//再扫描一下array看看是不是ascending array
public class Solution {
    public boolean solution(int[] array)
    {
        int left = 0;
        boolean find_left = false;
        boolean find_right = false;
        int right = array.length-1;
        while(left<right)
        {
            if(!find_left)
            {
                if (array[left]<array[left+1])
                {
                    left++;
                }
                else{
                    find_left = true;
                }
            }

            if(!find_right && array[right]>array[right-1])
            {
                if(array[right]>array[right-1])
                {
                    right--;
                }
                else{
                    find_right = true;
                }
            }
        }
        if(array[left]>array[right])
        {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        for(int i = 1;i<array.length;i++)
        {
            if(array[i]<array[i-1])
            {
                return false;
            }
        }
        return true;

    }
}
