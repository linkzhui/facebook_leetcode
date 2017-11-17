package Facebook.机器人走房间_1004;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

//利用bfs走room，同时用hashmap记录当前走过的点
//把最开始的点设置成原点（0，0），然后向左走（-1，0），把coordinates表示成string记录在HashSet里，来确保重复的点不会重复走
//为什么要把coordinate表示成string，不能设置一个额外的class来表示呢，因为hashset的对比两个object是比较地址的，所以没办法知道存在不存在.
//然后用一个count 来记录总共走了多少步
public class Solution {
    public int bfs(String cur){
        Deque<String> queue = new ArrayDeque<>();
        queue.offerFirst(cur);
        HashSet<String> set = new HashSet<>();
        set.add(cur);
        int count = 1;
        while(!queue.isEmpty())
        {
            cur = queue.pollFirst();
            count++;
            String[] index = cur.split(" ");
            String x = index[0];
            String y = index[1];

            //move right
            int temp_x = Integer.parseInt(x)+1;
            String next_ditect = temp_x+" "+y;
            if(move(0) && set.add(next_ditect))
            {
                queue.add(next_ditect);
            }

            //move left
            temp_x = Integer.parseInt(x)-1;
            next_ditect = temp_x+" "+y;
            if(move(1) && set.add(next_ditect))
            {
                queue.add(next_ditect);
            }

            //move up
            int temp_y = Integer.parseInt(y)+1;
            next_ditect = x+" "+temp_y;
            if(move(2) && set.add(next_ditect))
            {
                queue.add(next_ditect);
            }

            //move down
            temp_y = Integer.parseInt(y)-1;
            next_ditect = x+" "+temp_y;
            if(move(3) && set.add(next_ditect))
            {
                queue.add(next_ditect);
            }
        }
        return count;
    }

    private boolean move(int direction)
    {
        //direction:0,1,2,3
        return true;
    }
}
