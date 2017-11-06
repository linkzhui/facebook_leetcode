package Facebook.Number_of_islands_200;

//1 is land 0 is water
//we walk through all the position of the grid
//if we find a position in grid is land, we increase the num of island + 1,
//then run dfs begin this position, mark the nearby land to water
//the dfs function is: dfs(int row, int col, char[][] grid)
//after we mark all the land in the grid to water, the program finished

import java.util.Arrays;
import java.util.List;

//time complex: O(n^2)
//space complex: O(1) we only need two local variables
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int col = grid[0].length;
        int row = grid.length;
        int num = 0;
        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j<col;j++)
            {
                if(grid[i][j]!='0')
                {
                    num++;
                    helper(i,j,grid);
                }
            }
        }
        return num;
    }
    private void helper(int row, int col, char[][] grid)
    {
        if(row<0 || row>=grid.length || col<0 ||col>=grid[0].length || grid[row][col] == '0')
        {
            return;
        }else{
            grid[row][col] = '0';
        }
        helper(row+1,col,grid);
        helper(row-1,col,grid);
        helper(row,col+1,grid);
        helper(row,col-1,grid);

        List<String> list;
    }
}