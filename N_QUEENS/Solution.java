package Facebook.N_QUEENS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//time complex  O (n^n)
//space complex O (n^n)
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i< n; i++)
        {
            int[] cols= new int[n];
            result.addAll(process(helper(0,i,cols,n)));
        }
        return result;

    }

    private List<List<Integer>> helper(int currow, int curcol,int[] col,int n)
    {
        col[currow] = curcol;
        List<List<Integer>> result = new LinkedList<>();
        if (currow == n-1)
        {
            result.add(new LinkedList<>(Arrays.asList(col[currow])));
            return result;
        }
        for (int childcol = 0; childcol<n;childcol++)
        {
            if(!jianMian(col,childcol,currow+1))
            {
                List<List<Integer>> resultchild = helper(currow+1,childcol,col,n);
                for (List<Integer> resultchild1:resultchild)
                {
                    resultchild1.add(0,curcol);
                    result.add(resultchild1);
                }

            }
        }

        return result;
    }

    private boolean jianMian (int[] cols, int colChild, int rowChild)
    {
        for (int i = 0; i<rowChild;i++)
        {
            if(cols[i]==colChild||cols[i]-colChild==i-rowChild||cols[i]-colChild==rowChild-i)
            {
                //第一个是一条线，第二和第三是 等边三角形
                return true;
            }
        }
        return false;
    }

    private List<List<String>> process(List<List<Integer>> input)
    {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> listInput:input)
        {
            List<String> listOutput = new ArrayList<>();
            for (Integer val:listInput)
            {
                StringBuilder sb = new StringBuilder();
                for(int i =0;i<listInput.size();i++)
                {
                    sb.append(i == val? 'Q':'.');
                }
                listOutput.add(sb.toString());
            }
            result.add(listOutput);
        }
        return result;
    }
}
