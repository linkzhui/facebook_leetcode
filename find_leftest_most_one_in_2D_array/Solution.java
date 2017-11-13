package Facebook.find_leftest_most_one_in_2D_array;

//⼀一个⼆二维数组，每⼀一⾏行行都只有0和1，前⾯面部分是0，后⼀一部分
//是1，找到数组⾥里里⾯面最左边的1的那⼀一列列数


//special case: all zero , don't have one
//Assumpiton, if we didn't find the 1, we return Integer.MAX_VALUE;


public class Solution {
    public static void main(String[] args)
    {
        int[][] array = {{0,0,0},{0,1,1},{1,1,1}};
        Solution sol = new Solution();
        System.out.println(sol.search(array));
    }
    public int search(int[][] array)
    {
        if(array == null || array.length == 0 || array[0].length==0)
        {
            //Corner case
            return Integer.MAX_VALUE;
        }

        int first_one=array[0].length; //当前找到的最左边的1的位置，初始成array【0】.length

        for(int i = 0;i< array.length;i++)
        {
            first_one = Math.min(first_one,binary_search(array,i,first_one-1));
        }
        return first_one == array[0].length? Integer.MAX_VALUE:first_one;
    }
    public int binary_search(int[][] array,int row,int first_one)
    {
        int start = 0;
        int end = first_one;
        int mid;
        while(start+1<end)
        {
            //because the 1 may be not exist in current row, and we may have duplicate 1 in this row
            //therefore we need this condition, we avoid the infinite loop, when start and end are neighbor, we need to stop the while loop
            mid = start+(end-start)/2;
            if(array[row][mid]==1)
            {
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        if(array[row][start] == 1 || array[row][end] == 1)
        {
            return array[row][start] == 1? start:end;
        }
        return array[0].length;

    }
}
