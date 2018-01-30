package Facebook.Read_N_Characters_Given_Read4_157;


public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean keep_loop = false;
        char[] temp = new char[4];
        while (total<n && !keep_loop)
        {
            //temp是用来存储，读取的内容
            int count = read4(temp);
            keep_loop = count<4;


            //这里取一个min，因为如果文件的长度超过 n，count就会返回4，但是剩余要读的可能会比4小，所以要取一个min
            count = Math.min(n - total,count);
            for(int i = 0;i<count;i++)
            {
                buf[total++] = temp[i];
            }

        }
        return total;

    }

    private int read4(char[] temp) {
        return 0;
    }
}

