package Facebook.Read_N_Characters_Given_Read4_II_158;

public class Solution {
    private int count = 0;
    private int pointer = 0;
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while(index<n)
        {
            if(count == pointer)
            {
                count = read4(temp);
                pointer=0;
            }
            if(count == 0)
            {
                break;
            }
            while(index<n&&pointer<count)
            {
                buf[index++]=temp[pointer++];
            }

        }
        return index;


    }
    int read4(char[] buf)
    {
        return 0;
    }
}
