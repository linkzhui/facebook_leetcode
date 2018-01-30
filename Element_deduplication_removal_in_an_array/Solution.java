package Facebook.Element_deduplication_removal_in_an_array;

//Question 1.1: 给定一个排好序的数组，消除里面重复的元素，对于重复元素只保留一个怎么做
//return the length of new array

//Question 1.2: 最多值保留两个怎么做

//Q1.3: 对于重复的元素一个都不保留怎么做

//Q1.4: unsorted array, deduplication for adjacent letters repeatedly.

//Q1.5.1: Given an array of random numbers, push all the zero's of a given array
//to the end of the array. (The order of all other elements can be changed)

//Q1.5.2: Given an array of random numbers, push all the zero's of a given array
//to the end of the array. (The order of all other elements cannot be changed)
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1, 1, 2, 2, 3};
        System.out.println(sol.Q1_1_method_1(array));
    }

    //Q1.1 method 1:
    //use two point, slow and fast
    //slow: represents all elements to the left hand side of slow(IN_CLUDING slow) are the final result to return
    //fast: represents the current index
    int Q1_1_method_1(int[] array) {
        int slow = 0;
        if (array == null || array.length == 0) {
            return -1;
        }

        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                continue;
            } else {
                array[++slow] = array[fast];
            }
        }

        return slow+1;

    }




    //Q1.1 method2:
    //slow: represents all elements to the left hand side of slow(EX_CLUDING slow) are the final result to return
    //fast: represents the current index
    //这个时候就要拿slow-1和fast比较
    int Q1_1_method_2(int[] array)
    {
        int slow = 1;
        if (array == null) {
            return -1;
        }

        if(array.length<=1)
        {
            return array.length;
        }

        for(int fast = 1; fast<array.length;fast++)
        {
            if(array[slow-1]==array[fast])
            {
                continue;
            }

            array[slow++] = array[fast];   //这里++要放到后面是因为，结果不包括slow，所以要把值先换到slow的位置上，然后再slow ++
        }

        return slow;
    }

}


//Question 1.2: 最多值保留两个怎么做

class Solution_2{

    //slow: represents all the element to the left side of the array (including the slow) are the final result

    public static void main(String[] args)
    {
        Solution_2 sol = new Solution_2();
        int[] array = {1, 1,1,1, 2, 2, 2,3,3};
        System.out.println(sol.Q1_2_method_1(array));
    }
    int Q1_2_method_1(int[] array){

        int slow = 1;
        if(array==null)
        {
            return -1;
        }
        if(array.length<=2)
        {
            return array.length;
        }

        for(int fast = 2;fast<array.length;fast++)
        {
            if(array[slow-1]==array[fast])
            {
                continue;
            }

            array[++slow] = array[fast];
        }
        return slow+1;
    }

    int Q1_2_method_2(int[] array)
    {
        int slow = 2;
        if(array==null)
        {
            return -1;
        }

        if(array.length<=2)
        {
            return array.length;
        }

        for(int fast = 2;fast<array.length;fast++)
        {
            if(array[slow-2]==array[fast])
            {
                continue;
            }

            array[slow++] = array[fast];
        }
        return slow;
    }
}


//Q 1.3: 对于重复的元素一个都不保留

class Solution_3{

    //fast: current index;
    //begin: represent how many repeated character is meeted after meet a new character.
    //slow: represents to the left side of the slow (ex-cluding the slow) will be the final result
    int Q1_3_method1(int[] array)
    {
        int slow = 0;
        int fast = 0;
        if(array==null || array.length==0)
        {
            return -1;
        }

        while(fast<array.length)
        {
            int begin = fast;
            while(array[fast]==array[begin])
            {
                fast++;
            }
            if(fast-begin==1)
            {
                array[slow++] = array[begin];
            }
        }
        return slow;
    }

}

//Q 1.4 unsorted array, deduplication for adjacent letters repeatedly.
//俄罗斯方块
class Solution_4{
    int[] Q1_4(int[] array) {
        //cur: the current index of the array
        //use stack
        //1.push into the stack:
        //      every time when stack is empty or peek of the stack is not same with array[cur],
        //2.pop of the stack
        //      every time peek of the stack is not same with the array[cur]
        Deque<Integer> stack = new ArrayDeque<>();
        Integer prev = null;
        int cur = 0;
        while(cur<array.length)
        {
            if(stack.isEmpty() || stack.peekLast()!=array[cur])
            {
                stack.offerLast(array[cur++]);
            }
            else if(stack.peekLast() == array[cur])
            {
                prev = stack.pollLast();
                while(array[cur]==prev&&cur<array.length)
                {
                    cur++;
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i = 0;i<result.length;i++)
        {
            result[i] = stack.pollFirst();
        }
        return result;
    }
}


//Q1.5.1: Given an array of random numbers, push all the zero's of a given array
//to the end of the array. (The order of all other elements can be changed)
class Solution_5{
    public static void main(String[] args)
    {
        Solution_5 sol = new Solution_5();
        int[] array = {1,9,8,4,0,0,2,7,0,6,0};
        System.out.println(sol.Q_1_5_1(array));
    }

    //similar to quicksort, 从两端往里走
    //slow: represents all left of side of slow(in-cluding slow) are the finial result of non-zeros
    //fast: represents all elements are zeros;
    public int Q_1_5_1(int[] array)
    {
        int slow = 0;
        int fast = array.length-1;
        while(slow<=fast)   //这里要用到<= 是因为要考虑当只有一个数的时候，要判断是不是0
        {
            if(array[slow]!=0)
            {
                slow++;
            }
            else if(array[fast]==0)
            {
                fast--;
            }
            else{
                swap(array,slow++,fast--);
            }
        }
        return slow;
    }
    void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

//Q1.5.2: Given an array of random numbers, push all the zero's of a given array
//to the end of the array. (The order of all other elements cannot be changed)

class Solution_6{
    public static void main(String[] args)
    {
        Solution_6 sol = new Solution_6();
        int[] array = {1,9,8,4,0,0,2,7,0,6,0};
        System.out.println(sol.Q_1_5_2(array));
    }

    //slow: represents all left of side of slow(ex-cluding) are the finial result of non-zeros
    //fast: represents all elements to the right side of fast are zeros;
    public int Q_1_5_2(int[] array)
    {
        int slow = 0;
        for(int fast = 0;fast<array.length;fast++)   //这里要用到<= 是因为要考虑当只有一个数的时候，要判断是不是0
        {
            if(array[fast]==0)
            {
                continue;
            }
            else
            {
                array[slow++]=array[fast];
                slow++;
            }
        }
        for(int i =slow;i<array.length;i++)
        {
            array[i] = 0;
        }
        return slow;
    }
}

