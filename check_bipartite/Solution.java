package Facebook.check_bipartite;

import java.util.*;

//使用的是宽度搜索：
//１　初始化数组都为-1，
//２　利用ｑｕｅｕｅ宽度遍历图
//３　从任意源点出发，把node分类０，　或１
//４　遍历这点的邻接点，如果没有分类就分类与这个源点相反的类，如果已经分类并且和源点的类相反，那么就是合法点，如果是相同的类，那么就不能是二分图

public class Solution {
    final static int V = 4; // # of Vertices

    public boolean isBipartite(int G[][], int src) {
        //  The value 1 is used to indicate first color is assigned and value 0 indicates second color is assigned.
        int colorArr[] = new int[V];
        Arrays.fill(colorArr, -1);
        colorArr[src] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v)
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u])    return false;
        }
        return true;
    }
}
